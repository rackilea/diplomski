final int rows = 10;
for(int row = 1; row <= rows; row++) {
    for(int col = 1; col <= rows; col++) {
         System.out.print((col <=(rows - row))? " " : "*");
    }
    System.out.println();
}