public class NativeDoubleArrayProxy {

    // This is the native `inputArray' pointer.
    private long p;

    private int length;

    private NativeDoubleArrayProxy(long p, int length) {
        this.p = p;
        this.length = length;
    }

    public int length() {
        return length;
    }

    public native double getDouble(int index);

    public native void getDoubles(int startingIndex, double[] out, int outOffset, int length);
}