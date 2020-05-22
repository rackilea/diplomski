int rowMaxIndex = cell.length - 1;
 int columnMaxIndex = cell[0].length - 1;

 for (int i = 0; i < cell.length; i++){ 
   for (int j = 0; j < cell[i].length; j++){ 
      if ( cell[i][j] == '*' && 
         (i == 0 || i == rowMaxIndex  || j == 0 || j == columnMaxIndex) ){
            System.out.print("We messed up boyz");
      }
    }
 }