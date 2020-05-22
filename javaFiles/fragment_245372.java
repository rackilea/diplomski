private void drawShapes(GraphicsContext gc) {
    int r = 20;
    while (r <= 80) {
        gc.strokeOval(80-(r/2), 80, r, 60);
        r = r + 10;
    }
}