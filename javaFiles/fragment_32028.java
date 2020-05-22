public void connectingPoints()
{
    ArrayList<Point>  externals = new ArrayList<Point>();
    for(int i = 0; i<externals.size(); i++)
    {
        Point point = externals.get(i);
        Point minPoint = externals.get((i+1) % externals.size());
        int minXDistance = minPoint.x-point.x;
        int minYDistance = minPoint.y-point.y;
        double minDist = Math.hypot(minXDistance, minYDistance);

        for(int j = 0; j < externals.size(); j++)  // <- you had i++ here!
        {
            if (i == j) {
                continue;
            }

            Point testPt = externals.get(j);
            double dist = Math.hypot(point.x - testPt.x, point.y - testPt.y);
            if (dist < minDist)
            {
                minDist = dist;
                minPoint = testPt;
            }
        }
        getGraphics().drawLine(point.x, point.y, minPoint.x, minPoint.y);
        repaint();
    }
}