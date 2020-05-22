for (int i2 = 0; i2 < matrix.length; i2++)
for (int j2 = 0; j2 < matrix[i2].length; j2++)
    if (matrix[i2][j2] < minValue)
       {
          minValue = matrix[i2][j2];
          row = i2; // stores the current row to row variable
          col = j2  // stores current columb to col variable
       }
System.out.println("Minimum numbers is " +minValue+  " at row " +row+ ", and column " +col);