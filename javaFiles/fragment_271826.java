public void set(int row, int col) throws IndexOutOfBoundsException {
   if(row > capacityr) {
      if(col > capacityc) {
         //both row and col are too big
         boolean temp[][] = new boolean[row+1][col+1];

         //copy a
         for(int i = 0; i <= capacityr; i++) {
           for(int j = 0; j <= capacityc; j++) {
              temp[i][j] = a[i][j];
           }
         }

         //set all the new elements to false
         for(int i = capacityr+1; i <= row; i++) {
           for(int j = capacityc+1; j <= col; j++) {
              temp[i][j] = false;
           }
         }

         //set row and col and a to temp
         temp[row][col] = true;
         a = temp;

         //update capacity
         capacityr = row;
         capacityc = col;
      }
      else {
         //just row is too big
         boolean temp[][] = new boolean[row+1][capacityc+1];
         for(int i = 0; i <= capacityr; i++) {
           for(int j = 0; j <= capacityc; j++) {
              temp[i][j] = a[i][j];
           }
         }

         for(int i = capacityr+1; i <= row; i++) {
             temp[i][capacityc] = false;
         }
         temp[row][col] = true;
         a = temp;
         capacityr = row;
      }
  }
  else {
     if(col > capacityc) {
        //just col is too big
        boolean temp[][] = new boolean[capacityr+1][col+1];
        for(int i = 0; i <= capacityr; i++) {
           for(int j = 0; j <= capacityc; j++) {
               temp[i][j] = a[i][j];
           }
        }

        for(int j = capacityc+1; j <= col; j++) {
             temp[capacityr][j] = false;
        }
        temp[row][col] = true;
        a = temp;
        capacityc = col;
     }
     else {
        //neither are too big
        a[row][col] = true;
     }
  }
}