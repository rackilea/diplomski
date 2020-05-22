public enum eDay {
  eMON(i->i+1),
  eTUE(i->i+2);

  private final Function<Integer, Integer> loadClassStrategy;

  eDay(Function<Integer, Integer> loadClassStrategy) {
    this.loadClassStrategy = loadClassStrategy;
  }

  public int loadClass(int i) {
    return loadClassStrategy.apply(i);
  }
}

void aMethodSomewhere(eDay e) {
  e.loadClass(1);
}