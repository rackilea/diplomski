if(placement == Placement.HORIZONTAL) {
  for(int i = 0; i < shipSize; i++) {
    if(board[posY-1][posX-1+i] != '0') {
      System.out.println("Can't place down the ship ");
      success = false;
      break;
    }
  }

  // your code