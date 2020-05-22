for (int c = 0; c < 8; c++) {
    for (int r = 0; r < 8; r++) {
        Main.grid[r][c] = 1;
    }

    Main.grid[getRandom()][c] = 0; // assuming your getRandom() is within range
}