String colNames = {"1", "2", "3", "4", "5", "6", "7"};
DefaultTableModel model = new DefaultTableModel(colNames, 0);  <-- 0 rows

....

public void actionPerformed(ActionEvent e){
    // get 7 fields of data

    Object[] row = {data1, data2, data3, data4, data5, data6, data7};
    model.addRow(row);
}