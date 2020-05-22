public static Pos findIndexWithValue(int[][] maze, int value) {

    if (maze == null) {
        System.out.println("Maze is NULL! (FindIndexWithValue)");
        return null;
    } else {
        for (int x = 0; x < getMazeWidth(maze); x++) {
            for (int y = 0; y < getMazeHeight(maze); y++) {
                if (maze[x][y] == value) {
                    Pos returnPos = new Pos(x, y);
                    return returnPos;
                }
            }
        }
    }
    System.out.println("The Value You Are Looking For is not Present (findIndexWithValue)");
    return null;
}