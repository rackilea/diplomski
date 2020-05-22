if(placement == Placement.HORIZONTAL) {
  for(int i = 0; i < posX+shipSize; i++) {
    for(int j = 0; j < posX+shipSize; j++) {
      if(board[i][posX-1] != '0' || board[posY-1][i] != '0') {
        System.out.println("Can't place down the ship ");
        success = false;
        break;
      }
    }
  }