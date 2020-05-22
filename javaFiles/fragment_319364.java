public boolean hasNonEmptyNeighbor(int[] adjacentFrom) {
    for(int i = -1; i <= 1; ++i) {
      for(int j = -1; j <= 1; ++j) {
        if(validIndex(adjacentFrom, i, j) //Still inside the board
             &&                           // AND
           !isEmpty(adjacentFrom[0]+i     //not empty
                      ,adjacentFrom[1]+j)) {
          return true;
        }
      }
    }
    return false;
  }