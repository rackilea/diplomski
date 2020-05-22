public static int[][] blurMatrix(int[][] matrix){
    if(matrix == null || matrix.length <= 0)
      return null;

    int[][] blur = new int[matrix.length][];

    for(int row =0; row < blur.length; row++) {
      blur[row]= new int[matrix[row].length];

      // for all cols except the first one (we do not modify the first row)
      for(int col=blur[row].length-1; col>0; col--) {
        int cellValue = matrix[row][col];
        int previousCellValue = matrix[row][col-1];
        blur[row][col] = cellValue + previousCellValue;
      }

      // for the first column
      blur[row][0] = matrix[row][0];
    }
    return blur;
  }