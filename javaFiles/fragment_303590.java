JavaRDD<Vector> out = input.map(new Function<Tuple2<LongWritable, Vector>, Vector>() {

    @Override
    public Vector call(Tuple2<LongWritable, Vector> tuple) throws Exception {
        return tuple._2();
    }
});