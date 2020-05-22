Dataset<Row> df = ss.range(10).toDF();
        df.show();

        JavaPairRDD<Row, Long> rddzip = df.toJavaRDD().zipWithIndex();
        JavaRDD<Row> rdd = rddzip.map(s->{
            Row r = s._1;
            Object[] arr = new Object[r.size()+1];
            for (int i = 0; i < arr.length-1; i++) {
                arr[i] = r.get(i);
            }
            arr[arr.length-1] = s._2;
            return RowFactory.create(arr);
        });

        StructType newSchema = df.schema().add(new StructField("rowid",
                DataTypes.LongType, false, Metadata.empty()));

        Dataset<Row> df2 = ss.createDataFrame(rdd,newSchema);

        df2.show();