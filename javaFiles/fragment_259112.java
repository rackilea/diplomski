for (char put = '1' ; put <= '9' ; put ++) {
    if (isValid(row, col, board, put)) {
        char[][] boardTemp = board; // board and boardTemp are essentially the same thing
        boardTemp[row][col] = put;
        boolean valid = helper(nextRow, nextCol, boardTemp);
        if (valid) {
            // board is supposed to change only when valid is true.
            board[row][col] = put;
            return true;
        }
        // THIS IS WHAT YOU MISSED!!
        // if you don't reset the '.' back, your later backtrack will not work 
        // because you put an invalid number on your board and you will never find a solution
        boardTemp[row][col] = '.';
    }
}