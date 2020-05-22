private double sin(int degree) {
    return Math.sin(Math.toRadians(degree));
}

private double cos(int degree) {
    return Math.cos(Math.toRadians(degree));
}

@Override
public void paint(Graphics g) {
    super.paint(g);
    Polygon star = new Polygon();

    int radius = 20;
    int originX = 100;
    int originY = 100;
    int innerRadius = (int) Math.round(radius * sin(18) / sin(126));

    Point[] points = new Point[11];
    // top center 
    points[0] = new Point();
    points[0].x = 0;
    points[0].y = -radius;
    // inner top left
    points[1] = new Point();
    points[1].x = -(int) Math.round(innerRadius * cos(54));
    points[1].y = -(int) Math.round(innerRadius * sin(54));
    // top left 
    points[2] = new Point();
    points[2].x = -(int) Math.round(radius * cos(18));
    points[2].y = -(int) Math.round(radius * sin(18));
    // inner bottom left
    points[3] = new Point();
    points[3].x = -(int) Math.round(innerRadius * cos(18));
    points[3].y = (int) Math.round(innerRadius * sin(18));
    // bottom left
    points[4] = new Point();
    points[4].x = -(int) Math.round(radius * cos(54));
    points[4].y = (int) Math.round(radius * sin(54));
    // inner bottom center
    points[5] = new Point();
    points[5].x = 0;
    points[5].y = innerRadius;
    // bottom right
    points[6] = new Point();
    points[6].x = (int) Math.round(radius * cos(54));
    points[6].y = (int) Math.round(radius * sin(54));
    // inner bottom right
    points[7] = new Point();
    points[7].x = (int) Math.round(innerRadius * cos(18));
    points[7].y = (int) Math.round(innerRadius * sin(18));
    // top right
    points[8] = new Point();
    points[8].x = (int) Math.round(radius * cos(18));
    points[8].y = -(int) Math.round(radius * sin(18));
    // inner top right
    points[9] = new Point();
    points[9].x = (int) Math.round(innerRadius * cos(54));
    points[9].y = -(int) Math.round(innerRadius * sin(54));
    // top center
    points[10] = new Point();
    points[10].x = 0;
    points[10].y = -radius;

    for (int i = 0; i < points.length; i++) {
        star.addPoint(originX + points[i].x, originY + points[i].y);
    }
    g.drawPolygon(star);

}