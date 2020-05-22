static int traverseMatrix(int row, int col, int[][] matrix, boolean[][] visitStatus) {
    if (visitStatus[row][col] || matrix[row][col] == 0) {
        return 0;
    }
    visitStatus[row][col] = true;
    int count = 1;
    if (isValid(row, col - 1, matrix)) {
        count += traverseMatrix(row, col - 1, matrix, visitStatus);
    }
    ...
    return count;
}