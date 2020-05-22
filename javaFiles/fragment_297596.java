private static void walk(int[][] maze, int y, int x, int step) {
    if (y >= 0 && y < 8 && x >= 0 && x < 8 && maze[y][x] > step) {
        maze[y][x] = step;
        walk(maze, y - 1, x, step + 1);
        walk(maze, y + 1, x, step + 1);
        walk(maze, y, x + 1, step + 1);
        walk(maze, y, x - 1, step + 1);
    }
}