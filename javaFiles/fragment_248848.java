public boolean traverse(int row, int column){

   boolean done = false; 

   if(row == grid.length-1 && column == grid[0].length-1) {
      done = true;
   }else{
      done = traverse(row + 1. column); //down
      if(!done) {
         done = traverse (row, column+1)//right
      }
   }
   if (done) {
      grid[row][column] = PATH;
   }
   return done;
}