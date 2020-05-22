public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
     // get row data, and put it into an array
     Object[] row = {data1, data2, data3 ...};
     DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
     model.addRow(row);
 }