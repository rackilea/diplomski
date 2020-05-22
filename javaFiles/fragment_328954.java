public class MyThread extends Thread () {
  private static MyThread _me;

  private MyThread() { /* make constructors private it can only be made by getting an instance */ }

  public static MyThread getInstance() {
    if(_me == null) {
      _me = new MyThread();
    }
    return _me;
  }
}