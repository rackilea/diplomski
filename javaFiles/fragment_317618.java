public void printBoard() { // method for displaying the board
    for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
            System.out.print("[" + boardValueToString(board[row][col]) + "]" + " ");
        }
        System.out.println("");// spaces between each row and col
    }
}

public String boardValueToString(int value) {
        if (-1 == value) {
            return "O";
        }
        if (1 == value) {
            return "X";
        }
        return " ";
        // alt solution: return new String[]{"O", " ", "X"}[value + 1];
    }