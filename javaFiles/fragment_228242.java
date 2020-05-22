private static void place(int row, int col, int[][] rectangle) {
  if (canBePlacedHorizontally(row, col, rectangle)) {
    rectangle = deepCopy(rectangle);                  // A
    placeHorizontally(row, col, rectangle);           // B
    decideNextMove(row, col, rectangle);
  }
  if (canBePlacedVertically(row, col, rectangle)) {   // C
    rectangle = deepCopy(rectangle);
    placeVertically(row, col, rectangle);
    decideNextMove(row, col, rectangle);
  }
}