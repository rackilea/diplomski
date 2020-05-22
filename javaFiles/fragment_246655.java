import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

final class RzutMoneta {

  public static void main(String... argv) {
    int ilość;
    double headProbability;
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Number of threads: ");
      ilość = input.nextInt();
      System.out.print("Chance of heads: ");
      headProbability = input.nextDouble();
    }
    ExecutorService threads = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    for (int i = 0; i < ilość; ++i)
      threads.submit(() -> run(headProbability));
    threads.shutdown();
  }

  private static void run(double headProbability) {
    Moneta moneta = new Moneta(headProbability);
    int count = 0;
    while (moneta.rzut() == Moneta.Stroną.Reszka) {
      System.out.println(Thread.currentThread().getName() + ": tails!");
      ++count;
    }
    System.out.printf("%s: heads! %d tails%n", Thread.currentThread().getName(), count);
  }

}

final class Moneta {

  enum Stroną {
    Orzeł, Reszka
  }

  private final double headProbability;

  Moneta() {
    this(0.5);
  }

  Moneta(double headProbability) {
    if ((headProbability < 0) || (headProbability > 1))
      throw new IllegalArgumentException("Probability between 0.0 and 1.0");
    this.headProbability = headProbability;
  }

  Stroną rzut() {
    double toss = ThreadLocalRandom.current().nextDouble();
    return (toss < headProbability) ? Stroną.Orzeł : Stroną.Reszka;
  }

}