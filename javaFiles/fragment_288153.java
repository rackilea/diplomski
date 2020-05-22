public void drawBoard(){
    for (int i = 0; i < 8; i++){
        for (int j = 0; j < 8; j++){
            board[i][j] = null;

        }
        board[i][1] = new Piece(false);
    }
}