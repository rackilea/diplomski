//An arbitrary class that can belong to any package
public class ArbitraryClass {

    public static void main(String[] arguments){
        //creation of Shapes using ShapeFactory
        Shape myCircle = ShapeFactory.createCircle();
        Shape myTriangle = ShapeFactory.createTriangle();
    }
}