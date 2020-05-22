public class Example {
  // Create the lock
  static final Object lock = new Object();

  static Thread t1 = new Thread(new Runnable() {
    @SuppressWarnings("finally")
    public void run() {
      WebDriver driver = new FirefoxDriver(prof);
      driver.get("http://www.example.com");

      // synchronize on the lock
      synchronized(lock) {
        ((JavascriptExecutor) driver).executeScript("window.print();");
      }
    }
  });

  static Thread t2 = new Thread(new Runnable() {
    @SuppressWarnings("finally")
    public void run() {
      WebDriver driver = new FirefoxDriver(prof);
      driver.get("http://www.example.com");

      // synchronize on the lock
      synchronized(lock) {
        ((JavascriptExecutor) driver).executeScript("window.print();");
      }
    }
  });

  public static void main(String args[]) {
    t1.start();
    t2.start();
  }
}