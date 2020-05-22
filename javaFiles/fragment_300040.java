public static void fibonacci() {
  int lo = 0;
  int hi = 1;
  while (hi < 10000) {
    hi = hi + lo;
    lo = hi - lo;
    print(lo);
  }
}