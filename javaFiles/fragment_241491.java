public static void main(final String... args) {
  final Object o = new Object();
  // ... thread 1 ...
    synchronized(o) {
      if (boolean is in the expected state) { change boolean, get number, increment, print }
    }
  // ... thread 2 ...
    synchronized(o) {
      if (boolean is in the expected state) { change boolean, get number, increment, print }
    }
}