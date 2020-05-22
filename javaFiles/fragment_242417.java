private static List<Point> findNeighbours(int[][] maze, Point pt) {
    List<Point> neighbours = new ArrayList<>(8); // Reserve only 8 points
    int height = maze.length;
    if (height > 0) {
        int width = maze[0].length;
        for (int y = Math.max(pt.y - 1, 0); y <= Math.min(pt.y + 1, height); ++y) {
           for (int x = Math.max(pt.x - 1, 0); x <= Math.min(pt.x + 1, width); ++x) {
               if (!(y == pt.y && x == pt.x)) {
                   neighbours.add(new Point(x, y));
               }
           }
        }
    }
    return neighbours;
}