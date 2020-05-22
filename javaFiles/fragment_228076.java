public class MyClass {

    private static final Object MUTEX = new Object();

    public void doSomething() {
        synchronized(MUTEX) {
            // Do something
        }
    }

    public static void doSomethingStatic() {
        synchronized(MUTEX) {
            // Do something static
        }
    }
}