public class NotifyTest {
  private boolean flag = false;
  public synchronized boolean getFlag() {
    return flag;
  }
  public synchronized void setFlag(boolean newFlag) {
    flag = newFlag;
    notifyAll();
  }

  public static void main(String[] args) throws Exception {
    final NotifyTest test = new NotifyTest();

    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.printf("I am thread at %,d, flag is %b\n",
                          System.currentTimeMillis(), test.getFlag());
        synchronized (test) {
          try {
            test.wait();
          } catch (InterruptedException ie) {
            ie.printStackTrace();
          }
        }
        System.out.printf("I am thread at %,d, flag is %b\n",
                          System.currentTimeMillis(), test.getFlag());
      }
    }).start();

    System.out.printf("I am main at %,d, flag is %b\n",
                      System.currentTimeMillis(), test.getFlag());
    Thread.sleep(2000);
    test.setFlag(true);
    System.out.printf("I am main at %,d, flag is %b\n",
                      System.currentTimeMillis(), test.getFlag());
  }
}