private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        drawLine = true;
        repaint();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        drawLine = false;
        repaint();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private boolean drawLine = false;