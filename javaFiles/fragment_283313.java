import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

class Test
{

  private final CyclicBarrier sync = new CyclicBarrier(2);

  /** Duration of quarter beat in milliseconds. */
  private final int qb;

  Test(int bpm)
  {
    qb = 15000 / bpm;
  }

  private void cycle()
    throws InterruptedException, BrokenBarrierException
  {
    Timer timer = new Timer();
    timer.start();
    sync.await();
    for (int chunk = 0; chunk < 4; ++chunk)
      chunk();
    timer.interrupt();
  }

  private void chunk()
    throws InterruptedException, BrokenBarrierException
  {
    long t1 = System.nanoTime();
    for (int count = 0; count < 64; ++count) {
      playback();
      long t2 = System.nanoTime();
      sync.await(); /* Now wait the remaining time, if any. */
      long t3 = System.nanoTime();
      float t = TimeUnit.NANOSECONDS.toMillis(t2 - t1) / 1000F;
      float c = TimeUnit.NANOSECONDS.toMillis(t3 - t1) / 1000F;
      System.out.printf("Task: %5.3f, Cycle: %5.3f seconds%n", t, c);
      t1 = t3;
    }
  }

  void playback()
  {
    /* Simulate performing some work sleeping a random time which is, 
     * on average, an eighth of a beat, but can "jank" occasionally by taking 
     * too long to do its job. */
    long delay = (long) (-qb / 2 * Math.log(1 - Math.random()));
    // long delay = qb / 2; /* Simulate a predictable workload. */
    try {
      Thread.sleep(delay);
    }
    catch (InterruptedException abort) {
      Thread.currentThread().interrupt();
    }
  }

  private final class Timer
    extends Thread
  {

    @Override
    public void run()
    {
      try {
        sync.await();
        while (true) {
          Thread.sleep(qb);
          sync.await();
        }
      }
      catch (InterruptedException abort) {
        return;
      }
      catch (BrokenBarrierException ex) {
        ex.printStackTrace();
      }
    }

  };

  public static void main(String... argv)
    throws Exception
  {
    Test player = new Test(120);
    long t0 = System.nanoTime();
    player.cycle();
    System.out.printf("Total: %5.3f seconds%n", TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - t0) / 1000F);
  }

}