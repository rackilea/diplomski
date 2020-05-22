protected ArrayList<Shape> shapesOfSpecificType;

//Triangle can be added
public void addShape(Shape shape){
    shapesOfSpecificType.add(shape);
}

//List<Triangle> can be added
public void addShapes(List<? extends Shape> shapes){
     shapesOfSpecificType.addAll(shapes);
}