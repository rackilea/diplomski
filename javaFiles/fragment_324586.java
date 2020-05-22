public  static class Point {
    int x, y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }
}

public static void getPathsRec(int x, int y, Deque<Point> currentPath,
                               List<List<Point>> paths) {
    if (x == 0 && y == 0) {
        List<Point> path = new ArrayList<Point>();
        for (Point p : currentPath)
            path.add(p);
        paths.add(path);
        //System.out.println(currentPath);
        return;
    }

    if (x > 0 && is_free(x-1, y)) {
        currentPath.push(new Point(x-1, y));
        getPathsRec(x-1, y, currentPath, paths);
        currentPath.pop();
    }

    if (y > 0 && is_free(x, y-1)) {
        currentPath.push(new Point(x, y-1));
        getPathsRec(x, y-1, currentPath, paths);
        currentPath.pop();
    }
}

static int n = 2;
public static List<List<Point>> getPaths() {
    List<List<Point>> paths = new ArrayList<List<Point>>();
    Deque<Point> d = new ArrayDeque<Point>();
    d.push(new Point(n-1, n-1));
    getPathsRec(n - 1, n - 1, d, paths);
    //System.out.println(paths);
    return paths;
}