private static void place(int row, int col, int[][] rectangle) {
  if (canBePlacedHorizontally(row, col, rectangle)) {
    int[][] testrectangle = deepCopy(rectangle);      // A
    placeHorizontally(row, col, testrectangle);       // B
    decideNextMove(row, col, testrectangle);
  }
  if (canBePlacedVertically(row, col, rectangle)) {   // C
    int[][] testrectangle = deepCopy(rectangle);
    placeVertically(row, col, testrectangle);
    decideNextMove(row, col, testrectangle);
  }
}