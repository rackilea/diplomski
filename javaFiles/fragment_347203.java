public final class AppendMicrobenchmark {

  static void recursive(final StringBuilder builder, final int n) {
    if (n > 0) {
      recursive(builder.append(n), n - 1);
    }
  }

  static void iterative(final StringBuilder builder) {
    for (int i = 10000; i >= 0; --i) {
      builder.append(i);
    }
  }

  public static void main(final String[] argv) {
    /* warm-up */
    for (int i = 200000; i >= 0; --i) {
      new StringBuilder().append(i);
    }

    /* recursive benchmark */
    long start = System.nanoTime();
    for (int i = 1000; i >= 0; --i) {
      recursive(new StringBuilder(), 10000);
    }
    System.out.printf("recursive: %.2fus\n", (System.nanoTime() - start) / 1000000D);

    /* iterative benchmark */
    start = System.nanoTime();
    for (int i = 1000; i >= 0; --i) {
      iterative(new StringBuilder());
    }
    System.out.printf("iterative: %.2fus\n", (System.nanoTime() - start) / 1000000D);
  }
}