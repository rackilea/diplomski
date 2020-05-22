public static void main(String[] args) {
    printBoard();

    while (!isWinner()) {
        readMove(); // get move from stdin and mark on board
        printBoard(); // redraw board
    }

    printWinner(); // say who won
}