public static void main(String[] args) throws InterruptedException {
  Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {
      while (true) {
        int i = 0;
        i++;
      }
    }
  });
  t1.start();
  Thread.sleep(1000);
  t1.stop();
  Thread.sleep(1000);
  System.out.println(t1.isAlive());
}