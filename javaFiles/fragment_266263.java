public static void gridTranspose() {
    if (gridIsSquare() == true) {
        for (int r = 0; r < grid.length / 2 + 1; r++) {
            for (int c = r+1; c < grid[0].length; c++) {
                gridSwap(r, c, c, r);

            }
        }
    }
}