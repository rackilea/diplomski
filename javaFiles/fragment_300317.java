public Matrix transpose() {
    int[][] M = new int[numColumns][numRows];
    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numColumns; j++) {
            M[j][i] = data[i][j];
        }
    }
    return new Matrix(numColumns, numRows, M);
}