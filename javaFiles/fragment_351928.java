private boolean isWinningMove(int row, int col) {
    int piece = board[row][col];

    // check current row
    boolean w = true;
    for (int x = 0; x < 3; x++) { w = w && (board[row][x] == piece); }
    if (w) { return true; }

    // check current column
    w = true;
    for (int x = 0; x < 3; x++) { w = w && (board[x][col] == piece); }
    if (w) { return true; }

    // check 0,0 diagonal
    w = true;
    for (int x = 0; x < 3; x++) { w = w && (board[x][x] == piece); }
    if (w) { return true; }

    // check 0,2 diagonal
    w = true;
    for (int x = 0; x < 3; x++) { w = w && (board[x][2 - x] == piece); }
    return w;
}