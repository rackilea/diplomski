ConcurrentMap<Key, Value> myConcurrentMap = new MapMaker()
  .makeComputingMap(
    new Function<Key, Value>() {
      public Value apply(Key key) {
        Value calculatedValue = calculateValue(key);
        return calculatedValue;
      }
  });