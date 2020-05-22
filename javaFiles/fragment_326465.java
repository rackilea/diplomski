private static boolean checkIfLive (boolean[][] board, int row, int col) {

    int lastRow = board.length-1;
    int lastCol = board[0].length-1;

    if ((row >= 0 && row <= lastRow) && (col >= 0 && col <= lastCol)) {             
        return board[row][col];
    } else {
        return false;
    }
}