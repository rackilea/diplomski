public static void main(String[] args) {
    ArrayList<Shape> shapeArr = new ArrayList<Shape>(4);
    Circle c = new Circle();
    c.setRadius(10);
    Rectangle r = new Rectangle();
    r.setHeight(10);
    r.setWidth(5);

    shapeArr.add(c);
    shapeArr.add(r);
}