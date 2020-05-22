public class Medida extends CordovaPlugin {

  static {
      System.loadLibrary("finger");
  }

  public native int SFM_Init(byte[] dev);
}