for (int r = 0; r<board.length;r++){
   for (int c = 0; c <board.length;c++){
      board[r][c] = "?";  // Initialize the cell
      System.out.print("[" +board[r][c] + "]"); // Display the content of cell board
   }
   System.out.println();  // go to next line
}