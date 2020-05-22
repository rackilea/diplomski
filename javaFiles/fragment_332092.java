public static Function<Integer, Integer> intIncrementer(final int step) {
    class IntIncrementer implements Function<Integer, Integer> {
      private final int _step = step;

      @Override public Integer apply(Integer i) {
        return i + _step;
      }

      @Override public boolean equals(Object obj) {
        return (obj instanceof IntIncrementer) 
           && ((IntIncrementer) obj)._step == _step;
      }

      @Override public int hashCode() {
        return _step;
      }
    }

    return new IntIncrementer();
  }