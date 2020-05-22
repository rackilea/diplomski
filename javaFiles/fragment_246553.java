public void actionPerformed(ActionEvent e){
    // get 7 fields of data

    Object[] row = {data1, data2, data3, data4, data5, data6, data7};
    ((DefaultTableModel)jTable1.getModel()).addRow(row);
}