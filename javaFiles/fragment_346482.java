Line2D a = new Line2D.Double();
Line2D b = new Line2D.Double();
Line2D c = new Line2D.Double();

a.setLine(x1, y1, x2, y2);
b.setLine(x2, y2, x3, y3);
c.setLine(x3, y3, x1, y1);

double pntX = s.nextDouble();
double pntY = s.nextDouble();

if (a.ptLineDist(pntX, pntY) == 0 || b.ptLineDist(pntX, pntY) == 0 || c.ptLineDist(pntX, pntY) == 0)
    c++;