JavaRDD<String> crows = sessions.flatMap(new FlatMapFunction<Session, String>() {
    public Iterable<String>  call(T x) {
        List<String> someList = ...
        return someList;
    }
});