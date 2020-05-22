public class MyClass {

    public void doSomething() {
        synchronized(this) {
            // Do something
        }
    }

    public static void doSomethingStatic() {
        synchronized(MyClass.class) {
            // Do something static
        }
    }
}