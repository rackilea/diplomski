public static TicTacToe create(String input) {
    String[][] board = new String[3][3];
    int i = 0; // count the row we're on
    String[] tokens = input.split(",");
    for(int j = 0; j < board.length; j++) {
        if (j % 3 == 0) { // advanced to the end of the column set (SO)
            i++;
        }
        board[i][j] =  tokens[i*3 + j];
    }
    return new TicTacToe(board);
 }