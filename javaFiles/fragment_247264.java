DefaultTableModel tableModel = new DefaultTableModel();
JTable table = new JTable(tableModel);

tableModel.addTableModelListener(new TableModelListener() {
  @Override
  public void tableChanged(TableModelEvent e) {
    if ((e.getLastRow() + 1) == tableModel.getRowCount()) {
      // something was entered into the last row, add a new row
    }
  }
});