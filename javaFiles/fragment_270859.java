public void setValueAt(int row, int col, int value) throws IncorectValueException{
    if (!isAcceptableValue(row, col)) {
       throw new IncorectValueException();             
    }
      board[row][col] = value;
}

public boolean isAcceptableValue(int row, int col, int value){
   if(isInRange(row, col) && (value == EMPTY || value >= 0)){
     return true;
   }
   return false;
}