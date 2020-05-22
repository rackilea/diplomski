public void tableChanged(TableModelEvent e) {
  int row = e.getFirstRow();
  int column = e.getColumn();
  System.out.printf("[row: %d, column: %d]%n", row, column);
  model = (TableModel1) e.getSource();
  String columnName = model.getColumnName(column);
  System.out.println("columnName: " + columnName);
  Object data = model.getValueAt(row, column);

  if (model.getValueAt(row, column) == Boolean.TRUE) {
     System.out.println("Condition working");

     model.removeTableModelListener(this);
     model.removeRow(row);
     model.addTableModelListener(this);
  }
}