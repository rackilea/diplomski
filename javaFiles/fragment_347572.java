JavaRDD<String> rdd = sc.textFile("/home/impadmin/ravi.txt");
JavaRDD<Tuple2<Integer,String>> words = rdd.map(new Function<String, Tuple2<Integer,String>>() {

    @Override
    public Tuple2<Integer,String> call(String v1) throws Exception {
        // TODO Auto-generated method stub
        return new Tuple2<Integer, String>(v1.split(" ").length, v1);
    }
});
JavaRDD<Tuple2<Integer,String>> tupleRDD1=  tupleRDD.sortBy(new Function<Tuple2<Integer,String>, Integer>() {

        @Override
        public Integer call(Tuple2<Integer, String> v1) throws Exception {
            // TODO Auto-generated method stub
            return v1._1;
        }
    }, false, 1);
    System.out.println(tupleRDD1.first());
}