static Map<Point, List<Point>> neighbours = new HashMap<>();

static List<Point> getNeighbours(Point a) {
    List<Point> nb = neighbours.get(a);
    if (nb == null) {
        nb = new ArrayList<>(xOffset.length); // size the list
        for (int i=0; i < xOffset.length; i++) {
            int x = a.getX() + xOffset[i];
            int y = a.getY() + yOffset[i];
            if (x>=0 && y>=0 && x < 5 && y < 5) {
                nb.add(new Point(x, y));
            }
        }
        neighbours.put(a, nb);
    }
    return nb;
}