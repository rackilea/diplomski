for(int i = 1; i <= board.length; i++) {
    System.out.print(i +  " "); // try to indent your code properly
    for(int j = 0; j < board[i].length; j++) { // using board[i].length will make it so you don't need a square 2d-array, and it could even be jagged if you wanted.
        System.out.print(board[i][j] + " ");
    }
    System.out.println(); //Note: the quotes are unneeded.
}