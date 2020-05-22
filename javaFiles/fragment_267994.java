public void crop(Point p1, Point p2) {
double highX = 0;
double lowX = 0;
double highY = 0;
double lowY = 0;
ArrayList<Point> list = new ArrayList<Point>();
if (p1.getX() > p2.getX()) {
    highX = p1.getX();
    lowX = p2.getX();
} else {
    highX = p2.getX();
    lowX = p1.getX();
}
if (p1.getY() > p2.getY()) {
    highY = p1.getY();
    lowY = p2.getY();
} else {
    highY = p2.getY();
    lowY = p1.getY();
}
if (p1.equals(p2)) {
    list.add(p1);
    points = list;
    return;

}
double i = 0;
while (i < points.size()) {
    Point P = points.get((int) i);
    if (P.getX() < highX + EPSILON && P.getX() > lowX - EPSILON
            && P.getY() < highY + EPSILON && P.getY() > lowY - EPSILON) {
        list.add(P);
    }
    i++;
}//thank god
points = list;