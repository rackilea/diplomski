public abstract class Shape{
   // contains all common code related to shapes
   // such as child elements
   Shape parentNode; // This will help navigate up
   List<Shape> children; // This will help navigate down the tree
   // Define, merge, split methods which are common to all shapes
   // define shape specific methods
}
public class Rectangle : Shape{
   // Implement shape's abstract methods for this class
}

public class Sphere : Shape{
   // Implement shape's abstract methods for this class
}