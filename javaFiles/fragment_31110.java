JTable table = new JTable(modGen);

//...

modGen.setYear(boxYears.getSelectedIndex()+1);
for (int i = 0; i < modGen.getColumnCount(); i++) {
  String name = modGen.getColumnName(i);
  int viewIdx = table.convertColumnIndexToView(i);
  if (viewIdx >= 0) {
    table.getColumnModel().getColumn(viewIdx).setHeaderValue(name);
  }
}