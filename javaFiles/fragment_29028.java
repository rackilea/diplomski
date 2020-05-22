public void generateNextStep() {
    for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[0].length; j++){
            int live = getNeighborCount(i,j);
            if (board[i][j] == DEAD && live == 3){
                nextBoard[i][j] = LIVE;
            }
            else if (board[i][j] == LIVE && live <= 3 && live >= 2){
                nextBoard[i][j] = LIVE;
            }
            else{
                nextBoard[i][j] = DEAD;
            }
        }
    }
    board = nextBoard;
    nextBoard = new char[50][50];
    printBoard();
}