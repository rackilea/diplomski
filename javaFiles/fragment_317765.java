private static void printPairs(int n) {
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      long sum = (i * i) + (j * j);
      double root = Math.sqrt(sum);
      if (root == ((int) root)) {
        System.out.printf("Found pair (%d, %d): %d^2 + %d^2 = %d^2\n",
            i, j, i, j, (int) root);
      }
    }
  }
}