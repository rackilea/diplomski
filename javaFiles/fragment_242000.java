boolean isColumnVisible(Table table, int columnIndex) {
  int columnRight = 0;
  for( int i = 0; i <= columnIndex; i++ ) {
    columnRight += table.getColumn(i).getWidth();
  }
  int clientAreaWidth = table.getClientArea().width;
  int horizontalOffset = table.getHorizontalBar().getSelection();
  return columnRight - horizontalOffset <= clientAreaWidth;
}