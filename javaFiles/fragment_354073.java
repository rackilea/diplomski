if (gameMap[row][col] == null) {
  // Debug statement showing which row, col pairs weren't assigned
  System.out.println("(" + row + ", " + col + ") was not assigned!");
  gameMap[row][col] = new EmptySquare("Empty Square", 0);
  gameMap[row][col].setLocation(row, col);
}