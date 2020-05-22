public class SomethingCaller {
    public static Something something = null; // (1) does not cause class loading
    public static Class<?> somethingClass = Something.class; // (2) causes class loading

    public void doSomething() {
        new Something(); // (3) causes class loading
    }
}