public class MyTableModel extends AbstractTableModel {
  private final List<MyItem> items = new ArrayList<MyItem>();

  public int getRowCount() {
    return items.size();
  }

  public int getColumnCount() {
    return 3;
  }

  public String getColumnName(int columnIndex) {
    switch(columnIndex) {
      case 0:
        return "foo";
      case 1:
        return "bar";
      case 2:
        return "qux";
      default:
        assert false : "Invalid column index: " + columnIndex;
    }
  }

  public void addItem(MyItem item) {
    items.add(item);
    fireTableRowsInserted(items.size() - 1, items.size() - 1);
  }
}