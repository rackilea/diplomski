// add in CartesionPanel
private List<Point> points = new ArrayList<>();

public void drawPoint(Point point) {
    points.add(point);
    repaint();
}

private void drawPointOnPanel(Point point, Graphics g) {
    final int pointDiameter = 5;
    final int x = X_AXIS_FIRST_X_COORD + (point.x * xLength) - pointDiameter / 2;
    final int y = Y_AXIS_SECOND_Y_COORD - (point.y * yLength) - pointDiameter / 2;
    g.fillOval(x, y, pointDiameter, pointDiameter);
}

public void paintComponent(Graphics g) {
    // existing code ...

    // draw points
    points.forEach(p -> drawPointOnPanel(p, g))
}