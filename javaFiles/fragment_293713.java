int rows = 3;
 int cols = 4;
 int[] array = new int[rows*cols];
 int[] currentRow = new int[cols];
 for (int i = 0; i < rows; ++i) {
     for (int j = 0; j < cols; ++j) {
         currentRow[j] = array[i*cols + j];
     }
 }