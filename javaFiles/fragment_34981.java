class MyRunnable implements Runnable {
  @Override public void run {
    // this code will get executed by a thread
  }
}
  // ...
  final MyRunnable r = new MyRunnable();
  final Thread t = new Thread(t);
  t.start();