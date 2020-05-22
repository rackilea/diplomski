int valueAt(int[][] m, int row, int col) {
     if (0 > row || row >= m.length) {
         return 0;
     }
     int[] v = m[row];
     if (0 > col || col >= v.length) {
         return 0;
     }
     return v[col];
}

... = valueAt(matrix, row, col)
    + valueAt(matrix, row-1, col)
    + valueAt(matrix, row+1, col)
    + valueAt(matrix, row, col-1)
    + valueAt(matrix, row, col+1);