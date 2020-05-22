List<Shape> shapes = new ArrayList<>();
shapes.add(new Circle(30));
shapes.add(new Rectangle(200, 200));
shapes.add(new Text("some arbitrary long text for testing"));
for (Shape shape : shapes) {
    System.out.println("bounds = " + shape.getLayoutBounds());
    System.out.println("width  = " + shape.getLayoutBounds().getWidth());
    System.out.println("height = " + shape.getLayoutBounds().getHeight());
}