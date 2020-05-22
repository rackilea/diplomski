private static int checkSecDiag(int i, int j, int col, char[][] board){
    if(i == col-1)
        return 0;
    return checkSecDiag(i+1, j-1, col, board)
         + ((board[i][j] == board[i+1][j-1])) ? 1 : 0);
}