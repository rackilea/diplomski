travel(correctPath, 0, 0, 11, 8);

void travel(bool a[][], int row, int col, int finalRow, int finalCol) {
   // if we are already there stop
   if(finalRow == row && col == finalCol) return;

   // avoid comming back
   a[row][col]=false;

   // if the input is correct only on of this moves will be valid
   // try each of them and see which move we can make
   if(col - 1 >= 0 && a[row][col-1]) { left(); travel(a, row, col-1, finalRow, finalCol)};
   if(col + 1 < 8 && a[row][col+1]) { right(); travel(a, row,col+1, finalRow, finalCol)};
   if(row - 1 >= 0 && a[row-1][col]) { up(); travel(a, row-1, col, finalRow, finalCol)};
   if(row + 1 < 11 && a[row+1][col]) { down(); travel(a, row+1,col, finalRow, finalCol)};
}