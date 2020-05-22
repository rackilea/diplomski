public static void main(String [] args) throws InterruptedException {
  Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {
      while (true) {
        try {
          while (true) {
            int i = 0;
            i++;
          }
        } catch (Throwable e) {
          e.printStackTrace();
        }
      }
    }
  });
  t1.start();
  Thread.sleep(1000);
  t1.stop();
  Thread.sleep(1000);
  System.out.println(t1.isAlive());
}