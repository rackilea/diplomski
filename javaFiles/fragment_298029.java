public static void main(String[] args) {
    ...
    board();
    play();
    // remove winner(row,colm); it isn't doing anything here
    // turn has the right value of the winner here if play() is modified
}

public static void play() {
    // remove boolean playing = true; it is not needed
    for (;;) { // I call it the 'forever', but you can also write while(true)
        ...
        board[row][colm] = turn;
        board(); // move up unless you don't want to display the board on wins
        if (winner(row,colm)) {
            System.out.print(turn + " you win");
            return; // (or break) <-- otherwise turn has the wrong value in main
        }
        ...
    }
}