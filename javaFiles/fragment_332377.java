@Override
public void draw(Graphics g) {
    g.setColor(Color.gray); //fillColor
    int[] xPoints = getXs(this.points);
    int[] yPoints = getYs(this.points);
    int nPoints = xPoints.length;
    g.fillPolygon(xPoints, yPoints, nPoints);

}