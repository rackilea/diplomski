static String string = "";
static final Object lock = new Object();

public static void main(String[] args) {
  Thread t1 = new Thread() {
    public void run() {
      synchronized (lock) {
        ... update the string variable ...
        lock.notifyAll();
      }
    }
  };
  Thread t2 = new Thread() {
    public void run() {
      synchronized (lock) {
        try {
          lock.wait();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  };
  t2.start();
  t1.start();
}