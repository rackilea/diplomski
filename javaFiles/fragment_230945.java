JTable t = new JTable(/* set some table-model that will contain the data */);
...
/* get some table-model that will contain the data */
TableModel tm = t.getModel();
for (int i = 0; i < tm.getRowCount(); i++) {
  for (int j = 0; j < tm.getColumnCount(); j++) {
    Object o = tm.getValueAt(i, j);
    if (o instanceof Integer) {
      System.out.println((Integer)o);
    } else if (o instanceof String) {
      System.out.println((String)o);
    }
  }
}