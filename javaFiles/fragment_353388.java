public boolean hasAnyNull() {
   boolean found = false;
   for (int i = 0 ; !found && i < board.width ; i++) {
      for (int j = 0; !found && j < board.height ; j++ {
         if (board[i][j] == null) {
            found = true;
         }
      }
   }
   return found;
}