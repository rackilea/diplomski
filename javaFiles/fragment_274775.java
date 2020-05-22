import com.sun.jna.*;

public class MyClass {

    public static native boolean isDisconnected();

    static {
        Native.register("theDLL");
    }

    public static void main(String[] args) {
        MyClass.isDisconnected();
    }
}