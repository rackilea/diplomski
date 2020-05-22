@Override
public void setValueAt(Object aValue, int row, int column) {
    Vector rowVector = (Vector)dataVector.elementAt(row);
    rowVector.setElementAt(aValue, column);
    // update whole row instead of single cell
    fireTableRowsUpdated(row, row);
}