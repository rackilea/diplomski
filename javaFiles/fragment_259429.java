private boolean isSolved() {
  for(int i = 0; i < mazegame.board.length; i++) {
    for(int j = 0; j < mazegame.board[i].length; j++) {
      if(mazegame.board[i][j] == 0 && !mazegame.clickedBoard[i][j]) {
        return false;
      }
    }
  }
  return true;
}