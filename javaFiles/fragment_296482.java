JavaPairRDD<Integer,List<String>> r = 
  rddOfTuples.mapToPair((t)->{
    List<String> l = new ArrayList<>(t.productArity()-1);
    for (int i = 1; i < t.productArity(); i++) {
      l.set(i-1,t.productElement(i));
    }
    return new Tuple2<>(t._1,l);
  }));