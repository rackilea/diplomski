public class DatasetOutlineRowModel implements RowModel {

  @Override
  public Class getColumnClass(int column) {
    switch (column) {
      case 0:
        return Boolean.class;
      case 1:
        return Boolean.class;
      case 2:
        return String.class;
      case 3:
        return String.class;
      default:
        assert false;
    }
    return null;
  }

 // [snip]

  @Override
  public Object getValueFor(Object node, int column) {
    if (!(node instanceof DatasetHandle))
      return null;
    DatasetHandle handle = (DatasetHandle) node;
    switch (column) {
      case 0:
        return handle.isLatticeSelected();
      case 1:
        return handle.isSelected();
      case 2:
        return "";
      case 3:
        return "";
      default:
        assert false;
    }
    return null;
  }

  @Override
  public boolean isCellEditable(Object node, int column) {
    if (column > 1)
      return false;
    if (node instanceof DatasetHandle)
      return true;
    return false;
  }

  @Override
  public void setValueFor(Object node, int column, Object value) {
    if (!(node instanceof DatasetHandle))
      return;
    DatasetHandle handle = (DatasetHandle) node;
    if (column == 0) {
      handle.setLatticeSelected((Boolean) value);
    }
    if (column == 1) {
      handle.setSelected((Boolean) value);
    }

  }

}