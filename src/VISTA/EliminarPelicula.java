/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VISTA;

import CONTROLAR.Metodos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Pablo
 */
public class EliminarPelicula extends javax.swing.JInternalFrame {

    /**
     * Creates new form EliminarPelicula
     */
    public EliminarPelicula() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablePelicula = new javax.swing.JTable();
        btnEliminarPelicula = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("ELIMINAR PELICULA");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jtablePelicula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtablePelicula);

        btnEliminarPelicula.setText("ELIMINAR PELICULA SELECCIONADA");
        btnEliminarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPeliculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarPelicula)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnEliminarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        m = new Metodos();
        modelo = new DefaultTableModel();
        modelo = m.MostrarTodos();
        jtablePelicula.setModel(modelo);
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnEliminarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPeliculaActionPerformed
        if (jtablePelicula.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una pelicula para eliminar");
        }else
        {
            int pos = jtablePelicula.getSelectedRow();
            DefaultTableModel modelo1 = (DefaultTableModel) jtablePelicula.getModel();
            int id = Integer.parseInt(modelo1.getValueAt(pos, 0).toString());
            m = new Metodos();
           int e = JOptionPane.showConfirmDialog(rootPane, "¿ESTA SEGURO QUE DESEA ELIMINAR ESTA PELICULA?");
            if (e==0) //ESTE IF VALIDA QUE LA OPCION INGRESADA SEA "SI" EN LA PREGUNTA ¿DESEA ELIMINAR?
            {
                int eliminar = m.EliminarPelicula(id);
                if (eliminar >0) {
                    JOptionPane.showMessageDialog(rootPane, "Se elimino la pelicula seleccionada");
                    modelo = new DefaultTableModel();
                    modelo = m.MostrarTodos();
                    jtablePelicula.setModel(modelo);
                }else
                {
                    JOptionPane.showMessageDialog(rootPane, "Error: Eliminar pelicula no realizado");
                }
            }
            if(e==1)//ESTE ES "NO"
            {
                
            }
            
            if (e<0) //ESTE SIGNIFICA CERRAR LA X
            {
                JOptionPane.showMessageDialog(rootPane, "se presiono la X");
            }
        }
    }//GEN-LAST:event_btnEliminarPeliculaActionPerformed

     //variables
    
    Metodos m;
    DefaultTableModel modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarPelicula;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtablePelicula;
    private javax.swing.JPanel myPanel1;
    // End of variables declaration//GEN-END:variables
}
