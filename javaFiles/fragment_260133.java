public class blah{
    public native void meh();

    public static void main(String args[]) {
        meh();
    }
}
static {
    System.loadLibrary("thing");
}