private void deleteProductButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    //DefaultTableModel tableModel = (DefaultTableModel) this.productDisplaTable.getModel();
    //JTable table = new JTable(tableModel);    
    int selectedRowIndex = this.productDisplaTable.getSelectedRow();
    int selectedColIndex = this.productDisplaTable.getSelectedColumn();
    System.out.println(selectedRowIndex );
    System.out.println(selectedColIndex);
}