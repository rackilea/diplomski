public Polygon createPolygon(Segmentation segmentation) {
    Polygon p = new Polygon();
    List<Line2D> list = segmentation.getLineList();
    if (list.size() < 2) return p;

    Line2D line = list.get(0);
    addPoint(p, line.getP1());

    // loop through lineList and add all x and y coordinates to relative x
    // and y arrays
    for (int i = 1; i < list.size(); i++) {
        addPoint(p, line.getP2());
        line = list.get(i);
    }

    addPoint(p, line.getP2());
    return p;
}

protected void addPoint(Polygon p, Point2D point) {
    int x = (int) point.getX();
    int y = (int) point.getY();
    p.addPoint(x, y);
}