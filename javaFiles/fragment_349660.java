public void checkResult(String userGuess) {
        if (userGuess.equalsIgnoreCase(board[1][1])){
            System.out.println("hit!");
            numOfHitsOnFrigate++;
            board[1][1] = " *";
            createBoard();
        } else if (userGuess.equalsIgnoreCase(board[1][2])) {
            System.out.println("hit!");
            numOfHitsOnFrigate++;
            board[1][2] = " *";
            createBoard();
        } else {
            System.out.println("miss!");
            // try again
        }
        if (numOfHitsOnFrigate == 2) {
            System.out.println("Enemy frigate has been sunk!");
            frigateIsAlive = false;
        }
}