List<Integer> ids = new ArrayList<Integer>();
for(int i=0; i< numOfPartitions; i++){
    ids.add(i);
}

JavaRDD<Integer> seqRDD = javaSparkContext.parallelize(ids, numOfPartitions);