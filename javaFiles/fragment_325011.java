StructType schema = yourDataframe.schema();
schema.add(new StructField("id", DataTypes.LongType, false,null));
JavaRDD<Row> rdd = yourDataframe.toJavaRDD().zipWithIndex()
    .map(x -> {
         Collection<Object> row = JavaConverters.asJavaCollection(x._1.toSeq());
         Long index = x._2;
         row.add(index);
         return RowFactory.create(row);
    });
Dataset<Row> indexedData = spark.createDataFrame(rdd, schema);