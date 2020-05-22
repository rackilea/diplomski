// example declaration only - initially all zeros until you set them.
// assumes nrows and ncols are initialized and declared elsewhere
int [][] matrix = new int[nrows][ncols];
for (int i = 0; i < matrix.length; ++i) {
    for (int j = 0; j < matrix[i].length; ++j) {
        // operate on the values here.
        if (matrix[i][j] != 1) {
            matrix[i][j] -= 1;
        }
    }
}