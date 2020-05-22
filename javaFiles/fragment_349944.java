package my;

public class Classifier {
    public native void init(); // initialize _ptr with a new Classifier
    public native void cleanup(); // destroy Classifier
    public native byte[][] classify();
    private long _ptr;
}