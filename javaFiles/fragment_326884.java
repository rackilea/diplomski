int maxP(int i, int j, int steps, int[][] grid) {
    if (i < 0 || i >= n || j < 0 || j >= m || steps < 0) {
        return 0;
    }
    // check if place has been passed through before
    int cost = 0;
    if (lookup[i][j] == 0) {
        cost = grid[i][j];
    }

    // mark this place as visited
    lookup[i][j]++;

    // find the best cost recursively
    cost = cost + max(
                      maxP(i - 1, j - 1, steps - 1, grid),
                      maxP(i - 1, j, steps - 1, grid),
                      maxP(i - 1, j + 1,steps - 1, grid),
                      maxP(i, j - 1,  steps - 1, grid),
                      maxP(i, j + 1, steps - 1, grid),
                      maxP(i + 1, j - 1, steps - 1, grid),
                      maxP(i + 1, j, steps - 1, grid),
                      maxP(i + 1, j + 1, steps - 1, grid)
                      );

    // undo the change to the lookup table
    lookup[i][j]--;

    return cost;
}