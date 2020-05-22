import java.util.*;
import java.util.concurrent.*;

class Foo implements Runnable {
  private long count;
  private double threshold;
  private long result;

  public Foo(long count, double threshold) {
    this.count = count;
    this.threshold = threshold;
  }

  public void run() {
    ThreadLocalRandom rand = ThreadLocalRandom.current();
    for(long l=0; l<count; l++) {
      if(rand.nextDouble() < threshold)
        result++;
    }
  }

  public static void main(String[] args) throws Exception {
    long count = 1000000000;
    double threshold = 0.75;
    int cores = Runtime.getRuntime().availableProcessors();
    long sum = 0;

    List<Foo> list = new ArrayList<Foo>();
    List<Thread> threads = new ArrayList<Thread>();
    for(int i=0; i<cores; i++) {
      // TODO: account for count%cores!=0
      Foo t = new Foo(count/cores, threshold);
      list.add(t);
      Thread thread = new Thread(t);
      thread.start();
      threads.add(thread);
    }
    for(Thread t : threads) t.join();
    for(Foo f : list) sum += f.result;

    System.out.println(sum);
  }
}