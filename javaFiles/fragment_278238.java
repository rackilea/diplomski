public static void mirror(Object[][] theArray) {
  for (int j = 0; j < theArray.length; ++j) {  // Extra for loop to go through each row in turn, performing the reversal within that row.
    Object[] row = theArray[j];
    for(int i = 0; i < (row.length/2); i++) {
        Object temp = row[i];
        row[i] = theArray[j][row.length - i - 1];
        row[row.length - i - 1] = temp;
    }
  }
}