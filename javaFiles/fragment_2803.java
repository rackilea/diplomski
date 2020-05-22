class NonRepeatedPRNG {
  private final Random rnd = new Random();
  private final Set<Integer> set = new HashSet<>();
  public int nextInt() {
    for (;;) {
      final int r = rnd.nextInt();
      if (set.add(r)) return r;
    }
  }
}