void twoDimProcess(int[][] matrix) {
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = i*j;
        }
    }
}