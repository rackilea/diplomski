JavaRDD<Row> ff = vertex_dataframe.javaRDD().zipWithIndex().map(mapFunc);

    static SerialiFunJRdd<Tuple2<Row, java.lang.Long>, Row> mapFunc=new SerialiFunJRdd<Tuple2<Row, java.lang.Long>, Row>() {
        @Override
        public Row call(Tuple2<Row, java.lang.Long> rowLongTuple2) throws Exception {
            return RowFactory.create(rowLongTuple2._1().getString(0), rowLongTuple2._2());
        }
    }