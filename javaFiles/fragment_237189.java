public class MyClass {
    // fields here
    public static MyClass forObject1(double a, double b, double c) {
        return new MyClass(a, b, c, 0);
    }
    public static MyClass forObject2(double a, double c, double d) {
        return new MyClass(a, 0, c, d);
    }
    private MyClass(double a, double b, double c, double d) {
        // assign to fields here
    }
    // methods here
}