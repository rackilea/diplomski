public static int[][] transposeMatrix(int[][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;

    int[][] transposedMatrix = new int[n][m];

    for(int x = 0; x < n; x++) {
        for(int y = 0; y < m; y++) {
            transposedMatrix[x][y] = matrix[y][x];
        }
    }

    return transposedMatrix;
}