static int[][] fill(int[][] grid, int i, int j, int needed) {
    if (!boundaryCheck()) throw new RuntimeException();
    int[][] clone = new int[grid.length][grid[0].length];
    //Clone matrix grid
    for (int k = 0; k < clone.length; k++) {
        clone[k] = grid[k].clone();
    }
    propagate(clone, i, j, needed, grid[i][j]);
    return clone;
}

static void propagate(int[][] grid, int i, int j, int needed, int target) {
    if (!boundaryCheck() || grid[i][j] != target || needed == target) return;
    grid[i][j] = needed;
    propagate(grid, i+1, j, needed, target);
    propagate(grid, i-1, j, needed, target);
    propagate(grid, i, j+1, needed, target);
    propagate(grid, i, j-1, needed, target);
}