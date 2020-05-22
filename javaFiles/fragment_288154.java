public void drawBoard() {
    int j = -1;
    for (int i = 0; i < 64; i++) {
        // j represents your "column"
        // every 8 counts, a new column is found
        if ( i % 8 == 0 ) {
            j++;
        }

        // for the '1' column, set your piece, else null
        board[i] = ( j == 1) ? new Piece(false) : null;
    }
}