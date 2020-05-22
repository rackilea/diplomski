Dataset<Row> df = sparkSession.createDataFrame(data, schema);

    UDF3<WrappedArray<Integer>,Integer,Integer,List<Integer>> filterFunction =  (WrappedArray<Integer> input, Integer filtVal1,Integer filtVal2) -> {
        List<Integer> newLst= new ArrayList<>(JavaConversions.asJavaList(input));
        newLst.removeIf(x -> x==filtVal1 || x==filtVal2);
        return newLst;
    };

    sparkSession.udf().register("filterFunction", filterFunction, DataTypes.createArrayType(DataTypes.IntegerType));

    Dataset<Row> filteredDf= df.withColumn("Set_temp", functions.callUDF("filterFunction", df.col("Set"),functions.lit(3),functions.lit(4))).drop("Set").withColumnRenamed("Set_temp", "Set").filter("size(Set_temp)>0");

    filteredDf.show();

  +-----+---------+
  |Text2|      Set|
   +-----+---------+
  |  one|[1, 5, 2]|
  |  six|      [5]|
  | five|   [5, 2]|
  +-----+---------+