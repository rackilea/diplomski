public class NativeClass implements Runnable {

    public native void writeString(String s);

    static {
        System.loadLibrary("writestring");
    }

    @Override
    public void run() {
        writeString("Hello");
    }

}