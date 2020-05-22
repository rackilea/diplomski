public class GetThreadID {
    public static native int get_tid();

    static {
        System.loadLibrary("GetThreadID");
    }
}