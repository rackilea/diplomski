for (i = 0; i < boardSize; i++) {
    for (j = 0; j < boardSize; j++) {
        board[i][j] = new GridData();
        board[i][j].setIsOpen(true); 
        board[i][j].gridIsOpen();
        System.out.print(board[i][j] + " ");
    }
    System.out.println();
}