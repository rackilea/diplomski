String[][] boardPiece = {{"X", "", "O"}, 
                         {"O", "O","O"}, 
                         {"X", "", "X"}};

void setup() {
  println("X wins = "+ str(checkRows("X")));
  println("O wins = "+ str(checkRows("O")));
}

boolean checkRows(String XorO) { 
  for (int i=0; i<3; i++) { //for every row
    boolean win = true;     //set win to true
    for (int j=0; j<3; j++) { //for every column    
      if (boardPiece[i][j] != XorO) {  //if the column does not equal the sign that you are checking
        win = false;                   // meaning its the other, or it's empty, then set win to false
      }                                
    }
    if (win) {
      return true;    //if win is true, then there are 3 X's or 3 O's in this row, so return true
    }
  }
  return false;      // if none of the rows contain 3 equal, return false
}