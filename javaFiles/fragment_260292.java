boolean findEW(String word) {
  StringBuilder builder = new StringBuilder();

  // Why are your strings stored as a 2-dimensional character array??
  for(int r = 0; r < height; r++) {
    builder.append(grid[r]);
    builder.append("\n");
  }

  builder.reverse();
  return builder.toString().contains(word);
}