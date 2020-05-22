int[][] A = new int[Mouse.arrayRow][Mouse.arrayCol]; //giving array size
{
    for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A[i].length; j++) {
            A[i][j] = Mouse.arrayDetail.charAt(i * Mouse.arrayCol + j) - '0';
        }
    }
}