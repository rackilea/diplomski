private static Map<Integer, Integer> results = new HashMap<>();

public static int fasterFib(int n) {
  if (n == 0) {
    return 0;
  } else if (n <= 2) { // if
    return 1;
  }
  if (results.get(n) != null) {
    return results.get(n);
  } else {
    int v = fasterFib(n - 1) + fasterFib(n - 2);
    results.put(n, v);
    return v;
  }
}