Color color = Color.BLACK; // Default color
if ( isBorder(col, row)) {
    color = Color.RED;
}
...

private boolean isBorder(int col, int row) {
  return (row >= 0 && row <= 1) || (row >= 18 && row <= 19)  (col >= 0 && col <= 1) || (col >= 18 && col <= 19);
}