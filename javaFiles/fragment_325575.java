class PairFunctionImpl implements PairFunction<String, String, Integer> {
  @Override
  public Tuple2<String, Integer> call(String s) {
    return new Tuple2<String, Integer>(s, 1);
  }
}

JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunctionImpl());