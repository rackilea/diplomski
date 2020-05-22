import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;

public class Parent extends javax.swing.JInternalFrame {

    private final JDesktopPane pane;
    private final List<Child> children = new ArrayList<>();

    public Parent(final JDesktopPane pane) {
        this.pane = pane;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("Open child");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Close all");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1)
                                .addGap(37, 37, 37)
                                .addComponent(jButton2)
                                .addContainerGap(193, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(225, Short.MAX_VALUE)));

        pack();

    }// </editor-fold>

    private void jButton1ActionPerformed(final java.awt.event.ActionEvent evt) {
        Child c = new Child();
        children.add(c);
        pane.add(c);
        c.setVisible(true);
        c.toFront();
    }

    private void jButton2ActionPerformed(final java.awt.event.ActionEvent evt) {

        //CLOSE THIS WINDOW AND CHILD
        for (Child child : children) {

            child.dispose();
        }

        this.dispose();

    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration
}