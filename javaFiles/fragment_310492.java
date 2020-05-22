private boolean playHasFourInRow(int row, int col, char[][] board, int player) {
    return row > 3
        && board[row][col] == player
        && board[row-1][col] == player
        && board[row-2][col] == player
        && board[row-3][col] == player;
}