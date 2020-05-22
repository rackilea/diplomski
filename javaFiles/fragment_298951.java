public class Triangle extends Shape {
   ...
   public void draw () {
     System.out.println ("I have three sides");
   }
}

public class Square extends Shape {
   ...
   public void draw () {
     System.out.println ("I have four sides");
   }
}

... main () {

    Shape shapeA = new Triangle ();
    Shape shapeB = new Square ();

    shapeA.draw ();
    shapeB.draw ();