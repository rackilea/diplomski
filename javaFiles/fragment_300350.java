public static char[][] createArr(int row, int col, char ch) {
   char array[][] = null;

   if (row > 0 && col > 0) { 
       array = new char[row][col];

       for (int i = 0; i < col; i++) {
           for (int j = 0; j < row; j++) {
                array[j][i] = ch;
           }
       }
   }

   return array;
}