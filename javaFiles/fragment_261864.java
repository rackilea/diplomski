JavaPairDStream<String, String> jPairDStream =  stream.mapToPair(
        new PairFunction<ConsumerRecord<String, String>, String, String>() {
            @Override
            public Tuple2<String, String> call(ConsumerRecord<String, String> record) throws Exception {
                return new Tuple2<>(record.key(), record.value());
            }
        });

jPairDStream.foreachRDD(jPairRDD -> {
       jPairRDD.foreach(rdd -> {
            System.out.println("key="+rdd._1()+" value="+rdd._2());
        });
    });

jssc.start();            
jssc.awaitTermination();