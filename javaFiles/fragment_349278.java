wordCounts.foreachRDD(
    new Function<JavaPairRDD<String, Integer>, Void>() {
        public Void call(JavaPairRDD<String, Integer> rdd) {
            rdd.foreach(
                new VoidFunction<Tuple2<String,Integer>>() {
                    public void call(Tuple2<String,Integer> wordCount) {
                        System.out.println(wordCount._1() + ":" + wordCount._2());
                        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
                        Jedis jedis = pool.getResource();
                        jedis.select(0);
                        jedis.set(wordCount._1(), wordCount._2().toString());
                    }
                }
            );
            return null;
        }
    }
);