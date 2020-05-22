public void drawFractalTree(Graphics2D g, int x1, int y1, double angle, int depth, double size, double factor) {
    if (depth > 0) {
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * size * factor);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * size * factor);

        g.setStroke(new BasicStroke(0.5f * depth));
        g.drawLine(x1, y1, x2, y2);

        drawFractalTree(g, x2, y2, angle + 10, depth - 1, size, 1.0);
        drawFractalTree(g, x2, y2, angle - 35, depth - 1, size, 0.3);
        drawFractalTree(g, x2, y2, angle - 70, depth - 1, size, 1.0);
    }
}