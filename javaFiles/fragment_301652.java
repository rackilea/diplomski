public void paint... {
g = (Graphics2D) g.create();
    // convert from viewport to world bitmap
    Rectangle rect = object.getViewportBounds();
    g.translate(-rect.x, -rect.y);

    //set the line properties
    g.setColor(Color.RED);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setStroke(new BasicStroke(2));

    // do the drawing
    int lastX = -1;
    int lastY = -1;
    for (GeoPosition point : points) {
        Point2D pt = object.getTileFactory().geoToPixel(point, object.getZoom());
        if (lastX != -1 && lastY != -1) {
            g.drawLine(lastX, lastY, (int) pt.getX(), (int) pt.getY());
        }
        lastX = (int) pt.getX();
        lastY = (int) pt.getY();
    }
}