public static Dataset<Row> zipWithIndex(Dataset<Row> df, String name) {
    JavaRDD<Row> rdd = df.javaRDD().zipWithIndex().map(t -> {
        Row r = t._1;
        Long index = t._2 + 1;
        ArrayList<Object> list = new ArrayList<>();
        r.toSeq().iterator().foreach(x -> list.add(x));
        list.add(index);
        return RowFactory.create(list);
    });
    StructType newSchema = df.schema()
            .add(new StructField(name, DataTypes.LongType, true, null));
    return df.sparkSession().createDataFrame(rdd, newSchema);
}