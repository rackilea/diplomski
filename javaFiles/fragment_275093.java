public Rectangle(Point p1, Point p2) {
    this.setPoints(p1,p2);
}

private void setPoints(Point p1, Point p2) {
    boolean rectangleCondition = (p1.getX() != p2.getX()) && (p1.getY() != p2.getY());
    if (rectangleCondition) {
        this.p1 = p1;
        this.p2 = p2;
    }
    else{
        throw new IllegalArgumentException("x1/x2 y1/y2 shouldn't be equal");
    }
}