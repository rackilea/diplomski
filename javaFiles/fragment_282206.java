private static int getAllPaths(int[][] maze, int row, int col) {
    int[][] cache = new int[maze.length][maze[0].length];
    for (int i = 0; i < cache.length; i++) {
        Arrays.fill(cache[i], -1);
    }
    return getAllPaths(maze, cache, row, col);
}

private static int getAllPaths(int[][] maze, int[][] cache, int row, int col) {
    // Check cache
    if (cache[row][col] != -1)
        return cache[row][col];

    // Normal logic
    int paths;
    if (maze[row][col] == -1) {
        paths = 0;
    } else if (maze[row][col] == 2) {
        paths = 1;
    } else {
        paths = getAllPaths(maze, cache, row+1, col) + getAllPaths(maze, cache, row, col+1);
    }

    // Save result in cache
    cache[row][col] = paths;

    return paths;
}