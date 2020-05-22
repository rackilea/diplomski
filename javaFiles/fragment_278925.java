// for each row 
for (int row = 0; row < length; row++) {
  // the value of the previous column in this row
  // it doesn't really matter what we initialize this to
  // since we never use the initial value anyway
  int previous = 1;

  // for each column in this row
  // row 0 has 1 column and each subsequent row has one more
  for (int column = 0; column <= row; column++) {
      // the value of the current column in the row
      // the default value is 1, since that is always the value 
      // of the first column in every row
      int current = 1;

      // if the current column isn't the first, use formula
      // from the wikipedia article to compute the current column
      if (column != 0) {

          // we cast 'column' to a double so that the decimal does not get
          // truncated during division
          current = (int) (previous * ((row + 1 - column) / (double) column));
      }

      // print out the current column followed by a space
      System.out.print(current + " ");

      // set the value of the previous column to the current column value
      // this will be used in the next iteration of this for loop
      previous = current;
  }

  // print a new line to start a new row
  System.out.println();
}