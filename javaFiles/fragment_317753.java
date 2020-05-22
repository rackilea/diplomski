for(int i = 0; i < rows; i++){
   for(int j = 0; j < cols; j++){
      // The distance to the left, right, top and bottom border:
      int dl = j;
      int dr = cols - (j+1);
      int dt = i;
      int db = rows - (i+1);

      // The distance to the closest border:
      int d = Math.min(Math.min(dl, dr), Math.min(dt, db));

      // Print according number
      System.out.print(d+1);
   }
   System.out.println();
}