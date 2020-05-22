class ThreadNewTask implements Runnable {
  private BlockingQueue<Integer> pool;
  private int id;

  public ThreadNewTask(BlockingQueue<Integer> pool) {
    this.pool = pool;
  }

  public void run() {
    try {
        id = pool.take();
        someMethod(id);
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        pool.offer(id);
    }
  }

  private void someMethod(Integer id) {
    System.out.println("Task: " +id);
            // and do other calcuations whatever you need to do in your program
  }
}