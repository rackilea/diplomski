int p = 0;
int[][] matrix = new int[row][col];
for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++, p++) {
        matrix[i][j] = vector[p];
    }
}