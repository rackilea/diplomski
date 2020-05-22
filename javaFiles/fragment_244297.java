public static class eDays {
  public static final eDay eMON = new eDay(i -> i + 1);
  public static final eDay eTUE = new eDay(i -> i + 2);

  public static class eDay {
    private final Function<Integer, Integer> loadClassStrategy;

    public eDay(Function<Integer, Integer> loadClassStrategy) {
      this.loadClassStrategy = loadClassStrategy;
    }

    public int loadClass(int i) {
      return loadClassStrategy.apply(i);
    }
  }
}

void aMethodSomewhere(final eDays.eDay e) {
  e.loadClass(1);
}

// or even...

void aMethodSomewhere() {
  eDay eMON = new eDay(i -> i + 1);
  eMON.loadClass(1);
}