public class ConstructorInvoker {

    static {
        System.loadLibrary("constructorInvoker");
    }

    public static native void invoke(Object instance);
}