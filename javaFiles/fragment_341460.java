JavaPairRDD<Integer, String> linesA = sc.parallelizePairs(Arrays.asList(
                                            new Tuple2<>(1, "a1"),
                                            new Tuple2<>(2, "a2"),
                                            new Tuple2<>(3, "a3"),
                                            new Tuple2<>(4, "a4")));
JavaPairRDD<Integer, String> linesB = sc.parallelizePairs(Arrays.asList(
                                            new Tuple2<>(1, "b1"),
                                            new Tuple2<>(5, "b5"),
                                            new Tuple2<>(3, "b3")));
JavaPairRDD<Integer, String> linesC = sc.parallelizePairs(Arrays.asList(
                                            new Tuple2<>(1, "c1"),
                                            new Tuple2<>(5, "c6"),
                                            new Tuple2<>(6, "c3")));

// the list of RDDs
List<JavaPairRDD<Integer, String>> allLines = Arrays.asList(linesA, linesB, linesC);

// since we probably don't want to modify any of the datasets in the list, we will
// copy the first one in a separate variable to keep the result
JavaPairRDD<Integer, String> res = allLines.get(0);
for (int i = 1; i < allLines.size(); ++i) {  // note we skip position 0 !
    res = res.join(allLines.get(i))
    /*[1]*/  .mapValues(tuple -> tuple._1 + ':' + tuple._2);
}