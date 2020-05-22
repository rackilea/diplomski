public class MyClassInstanceHolder {
    private static ThreadLocal<MyClass> instance = new ThreadLocal<>();

    public static setInstance(MyClass instance) {
        instance.set(instance);
    }
    public static MyClass getInstance() {
        instance.get();
    }
}
...
MyClass myInstance = MyClassInstanceHolder.getInstance();