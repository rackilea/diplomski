protected void btnOpenotherdialogActionPerformed(ActionEvent e) {
    try {
        OtherDialog dialog = new OtherDialog();
        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}