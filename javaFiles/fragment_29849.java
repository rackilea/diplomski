public static void print(int x, int y) {
  for (int i = 0; i <= x; i++) {
    for (int j = 0; j <= y; j++) {
      if(i==0) { // first row
        if(j>0) {
          System.out.printf("%d\t", j);
        }
        else { // first row, first column: blank space
          System.out.printf("\t");
        }
      }
      else {
        if(j == 0) { // first column
          System.out.printf("%d\t", i); 
        }
        else { // actually in the body of the table - finally!
          System.out.printf("%d\t" i * j);
        }
      }
    }
    System.out.println();
  }
}