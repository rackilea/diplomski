public static void main(String[] args)
    throws Exception
  {
    int NUMBER_OF_THREADS = 400;
    ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    LongAccumulator sum = new LongAccumulator(Long::sum, 0);
    for (int i = 0; i < NUMBER_OF_THREADS; ++i) {
      executor.submit(new MMLGenerator(sum));
      TimeUnit.MILLISECONDS.sleep(50); /* Why??? */
    }
    int interval = 10;
    TimeUnit.SECONDS.sleep(interval);
    long rate = sum.getThenReset() / interval;
    System.out.println("--> MML rate is : " + rate + " MML per second.");
    executor.shutdownNow();
  }

  private static final class MMLGenerator
    implements Runnable
  {

    private final LongAccumulator counter;

    MMLGenerator(LongAccumulator counter)
    {
      this.counter = counter;
    }

    @Override
    public void run()
    {
      while (true) {
        counter.accumulate(1);
        try {
          TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException shutdown) {
          break;
        }
      }
    }

  }