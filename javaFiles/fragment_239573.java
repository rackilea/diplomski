public static void main(String[] args) throws InterruptedException {
    // create 3 threads and call first(), second() and third() sequentially
    for (int i = 0; i < 1000; i++) {
      SequentialExecution se = new SequentialExecution();
      Thread t1 = new Thread(se, "first");
      Thread t2 = new Thread(se, "second");
      Thread t3 = new Thread(se, "third");

      t3.start();
      t2.start();
      t1.start();
      t1.join();
      t2.join();
      t3.join();
    }

  }