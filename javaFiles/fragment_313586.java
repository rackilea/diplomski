JavaPairRDD<Integer, List<String>> original = // ...
JavaPairRDD<Integer, String> flattened = original.flatMapValues(identity());
JavaPairRDD<Integer, Tuple2<String, String>> joined = flattened.join(flattened);
JavaPairRDD<Integer, Tuple2<String, String>> filtered = 
    joined.filter(new Function<Tuple2<Integer, Tuple2<String, String>>, Boolean> () {
        @Override
        public Boolean call(Tuple2<Integer, Tuple2<String, String>> kv) throws Exception {
            return kv._2()._1().equals(kv._2()._2());
        }
    });