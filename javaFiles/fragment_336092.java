//ShapeFactory can be public, or package-private. Depends on programmer's needs
public class ShapeFactory {

    //If factory methods are static, then inner classes need to be static too!
    public static Circle createCircle(){
        return new Circle();
    }

    public static Triangle createTriangle(){
        return new Triangle();
    }


    /*Inner classes must  be set to private, to mask their existance
     from all other classes, except ShapeFactory. Static is only needed
     if the factory method that produces an instance of said class, is
     going to be static itself.*/
    static private class Circle implements Shape{
        private Circle(){
            //Circle implementation
        }
    }

    static private class Triangle implements Shape{
        private Triangle(){
            //triangle implementation
        }
    }

    //More inner classes, etc..

}