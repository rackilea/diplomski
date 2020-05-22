public static Polygon getPolygonOutline(BufferedImage image) {
    Area a  = getOutline(image, new Color(0, 0, 0, 0), false, 10); // 10 or whatever color tolerance you want
    Polygon p = new Polygon();
    FlatteningPathIterator fpi = new FlatteningPathIterator(a.getPathIterator(null), 0.1); // 0.1 or how sloppy you want it
    double[] pts = new double[6];
    while (!fpi.isDone()) {
        switch (fpi.currentSegment(pts)) {
        case FlatteningPathIterator.SEG_MOVETO:
        case FlatteningPathIterator.SEG_LINETO:
            p.addPoint((int) pts[0], (int) pts[1]);
            break;
        }
        fpi.next();
    }
    return p;
}