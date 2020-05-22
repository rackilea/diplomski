private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

    final JFileChooser  fileDialog = new JFileChooser();
    int returnVal = fileDialog.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        file = fileDialog.getSelectedFile();

        TestVDT call = new TestVDT(file);  
        jTextPane1.setText(file.toString());

        }          

}