// willingly share state over threads
class WillinglyStatefulRunnable {
  final BlockingQueue<Object> sharedObjects = new BlockingQueue<Object>();
  public void run() {
    sharedObjects.offer(new Object());
  }
}