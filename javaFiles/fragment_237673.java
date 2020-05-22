public boolean isCellEditable(int row, int col)
      { return true; }
 public void setValueAt(Object value, int row, int col) {
    rowData[row][col] = value;
    fireTableCellUpdated(row, col);
  }