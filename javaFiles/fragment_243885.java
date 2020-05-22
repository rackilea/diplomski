JavaRDD<UserLocation> jrdd;
JavaPairRDD<Long,UserLocation> jprdd = jrdd.mapToPair((v)->new Tupple2<>(v.id,v));
...

jprdd
  .foreach((k,v)->{
     System.out.println(v.toString());
  });