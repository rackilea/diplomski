protected Point toWorld(int x, int y) {
    return toWorld(new Point(x, y));
}

protected Point toWorld(Point p) {
    Point scaled = new Point(p);
    scaled.x = Math.round(p.x * ((float) DEFAULT_WIDTH) / (float) getWidth());
    scaled.y = Math.round(p.y * ((float) DEFAULT_HEIGHT) / (float) getHeight());
    return scaled;
}