@Override
public void setValueAt(Object value, int row, int col) {
  originalBoard[row][col] = ((Integer) value).intValue();
  System.out.println("Setting value");
  fireTableCellUpdated(row, col);
  // return true;
}