static void evolve() {

    char[][] temp = new char[m][n];
    for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
            int neighbors = count_neighbors(r, c);
            boolean occupied = grid[r][c] == 'X';
            if (occupied && neighbors < 2) {
                temp[r][c] = '.';
            } else if (occupied && neighbors > 3) {
                temp[r][c] = '.';
            } else if (occupied && (neighbors == 2 || neighbors == 3)) {
                temp[r][c] = 'X';
            } else if (!occupied && neighbors == 3) {
                temp[r][c] = 'X';
            } else {
                temp[r][c] = '.';
            }
        }
    }
    grid = temp.clone();
}