/**
* This method to check at run time with every change in any TextField 
* if the corresponding TextField has a valid value(i.e contains number and
* the first TextField value is less than the second)
* @param table
* @param numRows
*/
private static boolean hasValidValue(GridPane table, int numRows){
   // cycle through every row in the table
   // and compare every two TextFields
   for(int i=0; i<numRows; i++){
      try{ // try because user may enters a non-number input (to avoid crash)
         // the first TextField is always at column index 0 , the second at column index 3
         if(Integer.parseInt(((TextField)(getComponent (i, 0, table))).getText())>
            Integer.parseInt(((TextField)(getComponent (i, 3, table))).getText())){
            // before returning false
            textFieldIndex = i; // update at which row the TextField is less
            return false;
          }
       }catch(NumberFormatException e){ // if it contains invalid input(non-digit)
            return false;
       }
   }
   return true; 
}