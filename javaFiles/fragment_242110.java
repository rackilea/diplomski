List<Point> proxy = new ArrayList<>(points);
int[] xPoints = new int[proxy.size()];
int[] yPoints = new int[proxy.size()];
int nPoints = proxy.size();

int index = 0;
while (proxy.size() > 0) {
    Point p = proxy.remove(0);
    xPoints[index] = p.x;
    yPoints[index] = p.y;
    index++;
}

g2d.setColor(Color.RED);
g2d.fillPolygon(xPoints, yPoints, nPoints);
g2d.setColor(Color.BLACK);
g2d.drawPolygon(xPoints, yPoints, nPoints);