long sum = 0;
outer: for (int higher = 1; higher < 63; ++higher) {
  for (int lower = 0; lower < higher; ++lower) {
    long i = (1 << higher) + (1 << lower);
    if (i <= n) {
      sum += i;
    }
    if (i >= n) break outer;
  }
}