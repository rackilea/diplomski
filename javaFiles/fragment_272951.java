abstract class GeometricObject {
    /* You can actually draft a default implementation 
       here if you're using an abstract class.
       Otherwise you may want to opt for an interface.
    */
    abstract double getArea(); 
}
class Rectangle extends GeometricObject {
    @Override
    public double getArea() {
        // TODO calculations
        return 0; //draft
    }
}