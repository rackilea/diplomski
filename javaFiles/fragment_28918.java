private static final Polygon POLY = new Polygon();

static {
    POLY.addPoint(x1, y1); // first point
    POLY.addPoint(x2, y2); // second point
    POLY.addPoint(x3, y3); // third point
}

@Override
public void mouseClicked(final MouseEvent e) {
    if (POLY.contains(e.getX(), e.getY())) {
        // notify user
    }
}