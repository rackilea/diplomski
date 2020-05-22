// Define the UDF that takes the min of array
UDF1<Seq<Row>, Row> getElement = seq -> {
    Row bestRow = null;
    long bestRowScore = Long.MAX_VALUE;
    for (Row r : JavaConversions.seqAsJavaList(seq)){
        if (r.getBoolean(1) && r.getLong(2)<bestRowScore){
            bestRow = r;
            bestRowScore = r.getLong(2);
        }
    }
    return bestRow;
};

// Define the return type of UDF
ArrayType arrayType = (ArrayType) df.select(df.col("results.entities")).schema().fields()[0].dataType();
DataType elementType = arrayType.elementType();

// Register UDF
sparkSession.udf().register("getElement", getElement, elementType);

// Apply UDF on dataset
Dataset<Row> transformedDF = df.select(df.col("timestamp"),functions.callUDF("getElement", df.col("results.entities")));
transformedDF.printSchema();