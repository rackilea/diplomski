public static int[][] blurMatrix(int[][] matrix){
    if(matrix == null || matrix.length <= 0)
      return null;

    int[][] blur = new int[matrix.length][];

    for(int row =0; row < blur.length; row++) {
      blur[row]= new int[matrix[row].length];

      // for all cols except the last one (we do not modify the last row)
      for(int col=0; col<blur[row].length-1; col++) {
        int cellValue = matrix[row][col];
        int nextCellValue = matrix[row][col+1];
        blur[row][col] = cellValue + nextCellValue;
      }

      // for the last column
      int lastColumnIndex = blur[row].length-1;
      blur[row][lastColumnIndex]= matrix[row][lastColumnIndex];
    }
    return blur;
  }