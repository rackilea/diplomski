// The end of the list.
private static final Integer End = -1;

static class Producer implements Runnable {
  final Queue<Integer> queue;
  private int i = 0;

  public Producer(Queue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 1000; i++) {
        queue.add(i++);
        Thread.sleep(1);
      }
      // Finish the queue.
      queue.add(End);
    } catch (InterruptedException ex) {
      // Just exit.
    }
  }
}

static class Consumer implements Runnable {
  final Queue<Integer> queue;
  private int i = 0;

  public Consumer(Queue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    boolean ended = false;
    while (!ended) {
      Integer i = queue.poll();
      if ( i != null ) {
        ended = i == End;
        System.out.println(i);
      }
    }
  }
}

public void test() throws InterruptedException {
  Queue queue = new LinkedBlockingQueue();
  Producer p = new Producer(queue);
  Consumer c = new Consumer(queue);
  Thread pt = new Thread(p);
  Thread ct = new Thread(c);
  // Start it all going.
  pt.start();
  ct.start();
  // Close it down
  pt.join();
  ct.join();
}