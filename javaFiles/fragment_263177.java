// create the shared variable
final AtomicBoolean b = new AtomicBoolean();
// create your thread
Thread t = new Thread(new Runnable() {
  public void run() {
    // you can use b in here
  }
});
t.start();
// wait for the thread
t.join();
b.get();