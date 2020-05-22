Map<File, Dataset<Row> allWords = ...
StructField[] structFields = new StructField[] {
        new StructField("word", DataTypes.StringType, false, Metadata.empty()),
        new StructField("count", DataTypes.IntegerType, false, Metadata.empty()),
        new StructField("files", DataTypes.createArrayType(DataTypes.IntegerType), true, Metadata.empty())
};
StructType structType = new StructType(structFields);

Dataset<Row> allFilesWords = spark.createDataFrame(new ArrayList<>(), structType);
for (Map.Entry<File, Dataset<Row>> entry : allWords.entrySet()) {
    Integer fileIndex = files.indexOf(entry.getKey());
    allFilesWords.unionAll(
            allWords.get(entry.getKey())
                    .withColumn("files", functions.typedLit(seq, MyTypeTags.SeqInteger()))
    );
}