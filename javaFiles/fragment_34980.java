class MyThread extends Thread {
  @Override public void run() {
    // ... some code ...
  }
}
// ...
  final Thread t = new MyThread();
  t.start();