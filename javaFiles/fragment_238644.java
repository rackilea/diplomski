String[] colNames = {
       "QTY", "Item Code", "Amount"
};

DefaultTableModel model = new DefaultTableModel(colNames, 0);  <== 0 rows
JTable table = new JTable(model);