public class MethodHandle implements Runnable {
    private final Object object;
    private final Method method;

    public MethodHandle(Object object, java.lang.reflect.Method method) {
        this.object = Object;
        this.method = method;
    }

    @Override
    public void run() {
        method.invoke(object);
    }
}