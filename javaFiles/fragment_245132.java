public Point interpolate(Point p1, Point p2, double t){
    return new Point((int)Math.round(p1.x * (1-t) + p2.x*t), 
            (int)Math.round(p1.y * (1-t) + p2.y*t));
}

Point p1 = new Point(50,10);
Point p2 = new Point(10,100);
Point p3 = new Point(100,100);

Point p1p2a = interpolate(p1, p2, 0.2);
Point p1p2b = interpolate(p1, p2, 0.8);

Point p2p3a = interpolate(p2, p3, 0.2);
Point p2p3b = interpolate(p2, p3, 0.8);

Point p3p1a = interpolate(p3, p1, 0.2);
Point p3p1b = interpolate(p3, p1, 0.8);
...

g.drawLine(p1p2a.x, p1p2a.y, p1p2b.x, p1p2b.y);
g.drawLine(p2p3a.x, p2p3a.y, p2p3b.x, p2p3b.y);
g.drawLine(p3p1a.x, p3p1a.y, p3p1b.x, p3p1b.y);
QuadCurve2D c1 = new QuadCurve2D.Double(p1p2b.x, p1p2b.y, p2.x, p2.y, p2p3a.x, p2p3a.y);
QuadCurve2D c2 = new QuadCurve2D.Double(p2p3b.x, p2p3b.y, p3.x, p3.y, p3p1a.x, p3p1a.y);
QuadCurve2D c3 = new QuadCurve2D.Double(p3p1b.x, p3p1b.y, p1.x, p1.y, p1p2a.x, p1p2a.y);
g.draw(c1);
g.draw(c2);
g.draw(c3);