for (int i = 0; i < matrix.length; i++) {
    for (int j = 1; j < matrix[i].length - 1; j++) {
        if (matrix[i][j-1] == matrix[i][j] && matrix[i][j] == matrix[i][j+1]) {
            // do something here
        }
    }
}