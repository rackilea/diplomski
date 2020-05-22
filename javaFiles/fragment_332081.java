public ArrayList<Integer> findNeighboringChains(int i, int j) {
    ArrayList<Integer> neighboringChains = new ArrayList<>();

    Point p = new Point(i, j);
    List<Point> neighboringPoints = getNeighboringPoints(p);

    for (Point point : neighboringPoints) {
        int tmp = findChainId(point.x, point.y);
        if (tmp != -1) {
            neighboringChains.add(tmp);
        }
    }

    return neighboringChains;
}

/**
 * 
 * @param p
 *            The input point.
 * @return a list of points neighboring point p
 */
private List<Point> getNeighboringPoints(Point p) {
    ArrayList<Point> neighboringPoints = new ArrayList<Point>();
    neighboringPoints.add(new Point(p.x - 1, p.y));
    neighboringPoints.add(new Point(p.x + 1, p.y));
    neighboringPoints.add(new Point(p.x, p.y + 1));
    neighboringPoints.add(new Point(p.x, p.y - 1));
    return neighboringPoints;
}