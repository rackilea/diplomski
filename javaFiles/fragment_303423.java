public static boolean sudoku(int i, int j) {
    for (int n = 1; n < 10; n++) {
        // Try using n
        feld[i][j] = n;
        if (sudokuCorrect(i, j)) {
            if (i == 8 && j == 8) {
                // Last digit successful, we are done
                return true;
            }
            boolean followingSolved;
            if (j < 8) {
                followingSolved = sudoku(i, j + 1);
            } else {
                followingSolved = sudoku(i + 1, 0);
            }

            if (followingSolved) {
                // All following numbers successful, we are done
                return true;
            }
        }
        // n didn't fit, try next
    }
    // No number fit, current state not possible
    feld[i][j] = 0; // Cleanup attempt
    return false;
}