for (int i=0; i < matrix.length; ++i) {
    matrix[0][i] = i;
    matrix[i][0] = i;
    matrix[matrix.length-1][matrix.length-1-i] = i;
    matrix[matrix.length-1-i][matrix.length-1] = i;
}