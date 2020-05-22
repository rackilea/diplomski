for(int row = 0; row < dish.length; row++){ // each row
  for(int col = 0; col < dish[row].length(); col++){ // each char in the row

    int neighbors = 0;
    for (int r = Math.max(row - 1, 0); r < Math.min(row + 2, dish.length); ++r) {
      for (int c = Math.max(col - 1, 0); c < Math.min(col + 2, dish[row].length()); ++c) {
        // Don't count (row, col).
        if (r == row && c == col) continue;

        if (dish[r].charAt(c) == 'x') ++neighbors;
      }
    }

    //here ends the interesting part for you
    if(neighbors < 2 || neighbors > 3){
       // etc.