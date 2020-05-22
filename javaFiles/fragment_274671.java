public static int sumColumn(int[][] array, int column) {
  int sumn = 0;
  for(int i = 0; i < array.length; i++) {
    int row[] = array[i]; // get the row
    int numFromCol = row[column]; // get the value at the column from the given row
    sumn += numFromCol; // add the value to the total sum

  } 
  return sumn; // return the sum
}