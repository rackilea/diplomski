static void fillDown(int[][] grid) {
    for (int i = 1 ; i < grid.length ; i++){
        for (int j = 0 ; j < grid[i].length ; j++) {
            grid[i][j] = grid[0][j];
        }
    }
}