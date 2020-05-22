package Shapes;

public class ShapeFactory{

  public static Triangle createTriangle(){
    return new Triangle();
  }

  public static Circle createCircle(){
    return new Circle();
  }
}