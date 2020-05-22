public class MyClass {
  private static final Object countLock = new Object();
  private static int count = 0;

  public MyClass() {
    synchronized(countLock) {
      count++;
    }
    ...
  }
}