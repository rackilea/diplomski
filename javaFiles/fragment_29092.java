private ShapeCollection shapecollection;

public ShapeController(){
    ShapeCollection shapecollection= new ShapeCollection ();
}

public void makeBlock(double length, double width, double height)
{
    Shape shape = new Block( length,  width, height);
    shapecollection.addShape(shape);
}