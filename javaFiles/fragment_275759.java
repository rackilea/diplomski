for(int i = 0; i<rows; i++)  {
   for(int j = 0; j<col; j++)  {
       a[i][j] = min + (int)(Math.random()*(max-min+1)); // You need brackets and add it to min
   }
}
//Display on the screen
for(int i = 0; i<rows; i++) {
   for(int j = 0; j<col; j++){
       System.out.print(a[i][j]+ " ");
   }
   System.out.println(); // You need a linebreak
}