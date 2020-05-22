public class MultiThreading {
  public static void main(String[] args) throws Exception{
    // Use fair queuing to prevent an out-of-order task
    // from jumping to the head of the line again
    // try setting this to false - you'll see far more re-queuing calls
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1, true);
    for (int i = 5; i >= 1; i--) {
      Thread.sleep(100); // not necessary, just helps demonstrate the queuing behavior
      new MyThread(i, queue).start();
    }
    queue.add(1); // work starts now
  }

  static class MyThread extends Thread {
    int var;
    BlockingQueue<Integer> queue;

    public MyThread(int var, BlockingQueue<Integer> queue) {
      this.var = var;
      this.queue = queue;
    }

    @Override
    public void run() {
      System.out.println("Task " + var + " is now pending...");
      try {
        while (true) {
          int task = queue.take();
          if (task != var) {
            System.out.println(
                "Task " + var + " got task " + task + " instead - re-queuing");
            queue.add(task);
          } else {
            break;
          }
        }
      } catch (InterruptedException e) {
        // If a thread is interrupted, re-mark the thread interrupted and terminate
        Thread.currentThread().interrupt();
        return;
      }

      System.out.println("Finished task " + var);

      System.out.println("Registering task " + (var + 1) + " to run next");
      queue.add(var + 1);
    }
  }
}