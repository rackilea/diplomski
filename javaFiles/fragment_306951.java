void runTests() {
  Runner testCase = new Runner();
  ExecutorService executor = Executors.newCachedThreadPool();

  for (int i = 0; i < THREAD_COUNT; i++) {
    executor.execute(testCase);
  }
  executor.shutdown();
  executor.awaitTermination(60, TimeUnit.SECONDS);
  System.out.println(counter.toString());
}

private AtomicLong counter = new AtomicLong();

public class Runner implements Runnable {

    public void run() {
      StopWatch stopwatch2 = ... // get a stopwatch instance here

      for (int i = 0; i < Benchmarker.QUERY_COUNT; i++) {

        stopwatch2.start(); // this needs to reset the stopwatch to 0
        List<Person> selectData = dataHandler.selectData();
        stopwatch2.stop();
        counter.addAndGet(stopwatch2.getStopwatchValue());

       }
    }
}