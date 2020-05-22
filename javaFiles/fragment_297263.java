List<List<String>> Rows = new ArrayList();
for (int i = 0; i < jTable1.getRowCount(); i++) {
    List<String> Temp = new ArrayList();
    for (int x = 0; x < jTable1.getColumnCount(); x++) {
        Rows.Add(jTable.GetModel.getValueAt(i,x));
     }
}