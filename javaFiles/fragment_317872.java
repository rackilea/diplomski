class NativeWrapper {
  // either
  static {
    System.loadLibrary("MyOpenCVNative");
  }
  // or
  public NativeWrapper() {
    System.loadLibrary("MyOpenCVNative");
  }
  public native void callNative();
}