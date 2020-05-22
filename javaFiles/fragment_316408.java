public class run implements Callback {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    run r = new run();
    test.SetCallback(r, Log.blah);
    test.TestIt("Hello world");
  }

  public void Log(Log l, String s) {
    System.out.println("Hello from Java: " + s);
  }
}