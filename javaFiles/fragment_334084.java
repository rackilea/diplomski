@Override
public void setValueAt(Object aValue, int row, int column) {
    super.setValueAt(aValue, row, column);
    if (column == 1)
        fireTableRowsUpdated(row, row);
}