new FlatMapFunction<Tuple2<String, Tuple2<Iterable<Row>, Iterable<Row>>>, Row>() {
        @Override
        public Iterator<Row> call(Tuple2<String, Tuple2<Iterable<Row>, Iterable<Row>>> row) {
        //...
        }
};