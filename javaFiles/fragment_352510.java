for(int i = 1; i <= board.length; i++) {
    System.out.print(i +  " ");
    for(int j = 0; j < board[i].length; j++) {
        if (isrevealed(i,j)) System.out.print(board[i][j] + " ");
        else System.out.print("* ");
    }
    System.out.println();
}