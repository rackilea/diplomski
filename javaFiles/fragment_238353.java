public abstract class AbstractFactory {
        abstract Color getColor(String color);
        abstract Shape getShape(String shape) ;
    }
    /**
     * CONCRETE FACTORY1
     */
    class HighResolutionFactory extends AbstractFactory{
        Color getColor(String color){
            return new HighResolutionColor();
        }
        Shape getShape(String shape){
            return new HighResolutionShape();
        }
    }

    /**
     * CONCRETE FACTORY2
     */
    class LowResolutionFactory extends AbstractFactory{
        Color getColor(String color){
            return new LowResolutionColor();
        }
        Shape getShape(String shape){
            return new LowResolutionShape();
        }
    }
    class Color{} // ABSTRACT PRODUCT 1
    class Shape{} // ABSTRACT PRODUCT 2
    class HighResolutionColor extends Color{}// CONCRETE PRODUCT1 FACT 1
    class HighResolutionShape extends Shape{}// CONCRETE PRODUCT2 FACT 1
    class LowResolutionColor extends Color{}//...
    class LowResolutionShape extends Shape{}