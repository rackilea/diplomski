static Iterable<String> f(final int n) {
  return strings(n, n);
}

public static void main(final String[] argv) {
  for (int n = 1; n <= 5; ++n) {
    for (final String string : f(n)) {
      System.out.printf("%s ", string);
    }
    System.out.println();
  }
}