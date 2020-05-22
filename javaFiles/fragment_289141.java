// The board size.
private static final int SIZE = 8;
// Contents of board squares when empty.
private static final int EMPTY = -1;
// The 8 possible x,y moves for the knight.
private static final int[] x = {2, 1, -2, 1, -1, -2, -1, 2};
private static final int[] y = {1, 2, 1, -2, -2, -1, 2, -1};

public static void printBoard(int[][] board) {
    // Print out the board.
    for (int d = 0; d < SIZE; d++) {
        for (int e = 0; e < SIZE; e++) {
            System.out.print(board[d][e] + " ");
        }
        System.out.println();
    }

}

public static boolean knightsMove(int[][] board, int i, int j, int count) {
    boolean finished = false;
    // Only step onto empty squares that are on the board.
    if (i >= 0 && i < SIZE && j >= 0 && j < SIZE && board[i][j] == EMPTY) {
        // Mark my route.
        board[i][j] = count;
        // Count up.
        count += 1;
        // Are we done?
        if (count > SIZE * SIZE) {
            System.out.println("=== Solution ===");
            // Print the solution.
            printBoard(board);
            // Finished now.
            return true;
        }
        if (count == SIZE * SIZE) {
            // Nearly there - print something to show progress.
            System.out.println("=== Try === (" + i + "," + j + ")=" + count);
            // Print the current state.
            printBoard(board);
        }
        // Look around to try all moves from here.
        for (int u = 0; u < x.length && !finished; u++) {
            // Try the next place.
            finished = knightsMove(board, i + x[u], j + y[u], count);
        }
        // Clear my trail - you missed this.
        board[i][j] = EMPTY;
    } else {
        // Cannot go there.
        return false;
    }
    return finished;
}

public static void knightsMove() {
    int[][] board = new int[SIZE][SIZE];
    // Clear to EMPTY.
    for (int d = 0; d < board.length; d++) {
        for (int e = 0; e < board[d].length; e++) {
            board[d][e] = EMPTY;
        }
    }
    // Start at (7,7) with count 1.
    knightsMove(board, 7, 7, 1);
}