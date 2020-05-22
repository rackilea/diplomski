public class Threading {
    static{ System.LoadLibrary("Threading"); }

    private Runnable r = null;
    private native void StartNativeThread(Runnable r);

    public Threading(Runnable r) {
        this.r = r;
    }

    public void start() {
        StartNativeThread(this.r);
    }
}