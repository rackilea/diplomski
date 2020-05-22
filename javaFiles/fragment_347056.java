private void jButton1ActionPerformed(java.awt.event.ActionEvent e) {

    DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
    String firstName = jTextField1.getText();
    String mi = jTextField2.getText();
    String lastName = jTextField3.getText();

    String[] row = {firstName, mi, lastName};
    model.addRow(row);
}