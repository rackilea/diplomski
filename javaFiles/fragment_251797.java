protected Point toView(int x, int y) {
    return toView(new Point(x, y));
}

protected Point toView(Point p) {
    Point scaled = new Point(p);
    scaled.x = Math.round(p.x * ((float) getWidth() / (float) DEFAULT_WIDTH));
    scaled.y = Math.round(p.y * ((float) getHeight() / (float) DEFAULT_HEIGHT));
    return scaled;
}