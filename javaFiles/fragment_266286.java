public void swapRows(double[][] matrix, int row1, int row2, int start, int end) {
      double d = matrix[row1][start];
      matrix[row1][start] = matrix[row2][start];
      matrix[row2][start] = d;
      start++;
      if(start==end) {
          return;
      }
      swapRows(matrix, row1, row2, start, end);
  }