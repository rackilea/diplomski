interface NaturalNumber {
  void increment();
  default void add(int n) {
    for (int i = 0; i < n; i++) {
      increment();
    }
  }
}

class NaturalNumberImplementation implements NaturalNumber {
  private int n = 0;
  @Override public void increment() { n++; }
}