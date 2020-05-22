public TransposedTableModel extends AbstractTableModel {

  private TableModel innerTableModel;

  public TransposedTableModel(TableModel innerTableModel) {
     this.innerTableModel = innerTableModel;
  }

  @Override
  public int getRowCount() {
     return innerTableModel.getColumnCount();
  }

  @Override
  public   int getColumnCount() {
     return innerTableModel.getRowCount();
  }

  Override
  public   Object getValue(int row, int column) {
     return innerTableModel.getValue(column, row);
  }
};