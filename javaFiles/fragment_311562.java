for (int j = 0; j < matrix[i].length; j++) {
    if(j == matrix[i].length-1) {
        bw.write(matrix[i][j]);
    } else {
        bw.write(matrix[i][j] + ",");
    }
}