// your external loop
while (!finished) {

    /* Displaying the board, prompting for inputs */

    // Calculating number of data entries across the board
    int dataEntries = 0;
    for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
            if (board[row][col] != '.') {
                dataEntries ++;
            }
        }
    }

    // Break loop if there are 9 data entries
    if (dataEntries > 8) {
        System.out.println("Board is full, game over.");
        break;
    }
}