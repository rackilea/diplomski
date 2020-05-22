import java.util.*;
import java.util.concurrent.*;

public class WebServiceTester {

  public static class Tester
        implements Callable {
    public Integer call() {
      Integer start = now();
      //Do your test here
      Integer end = now();
      return end - start;
    }
  }

  public static void main(String args[]) throws Exception {
    ExecutorService pool = Executors.newFixedThreadPool(1000);
    Set<Future<Integer>> set = new HashSet<Future<Integer>>();
    for (int i =0 ; i < 1000 i++) {
      set.add(pool.submit(new Tester()));
    }
    Set<Integer> results = new Set<Integer>();
    for (Future<Integer> future : set) {
      results.put(future.get());
    }

    //Manipulate results however you wish....
  }
}