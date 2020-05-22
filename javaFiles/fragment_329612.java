public void addRect(){
    //Create new Shape
    Shape shape = new Shape();

    //Set shape's properties
    shape.x1 = (int) (Math.random() * getWidth() / 4.0);
    shape.x2 = (int) (Math.random() * getHeight() / 4.0);
    shape.y1 = (int) (Math.random() * getWidth());
    shape.y2 = (int) (Math.random() * getHeight());
    shape.color =  new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));

    //Add the shape to the list
    this.rectList.add(shape);
}