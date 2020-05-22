private static long lastNanos;
public static synchronized String uniqueId() {
  for (;/*ever*/;) {
    final long n = System.nanoTime();
    if (n == lastNanos) continue;
    lastNanos = n;
    return "" + System.currentTimeMillis() + n;
  }
}