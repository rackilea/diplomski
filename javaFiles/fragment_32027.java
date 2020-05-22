public void connectingPoints()
{
    ArrayList<Point>  externals = new ArrayList<Point>();
    for(Point p : externals) {
        Point minPoint = p.getClosestPoint(externals);
        getGraphics().drawLine(point.x, point.y, minPoint.x, minPoint.y);
        repaint();
    }
}