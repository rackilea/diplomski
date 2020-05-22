public class Sudoku extends NumberBoard {
     ...
public boolean isAcceptableValue(int row, int col, int value){ 
   if(isInRange(row, col) && (value==EMPTY || (value >= 1 && value <= 9))) {
      return true;             
    }       
    return false;
}