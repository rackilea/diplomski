SparkConf sparkConf = new SparkConf()
    .setAppName("Converter Service")
    .setMaster("local[*]");

SparkSession sparkSession = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate();

// read input data
Dataset<Row> events = sparkSession.read()
    .format("json")
    .schema(inputConfig.getSchema()) // StructType describing input schema
    .load(inputFile.getPath());

// write data out
DataFrameWriter<Row> frameWriter = events
    .selectExpr(
        // useful if you want to change the schema before writing it to ORC, e.g. ["`col1` as `FirstName`", "`col2` as `LastName`"]
        JavaConversions.asScalaBuffer(outputSchema.getColumns()))
    .write()
    .options(ImmutableMap.of("compression", "zlib"))
    .format("orc")
    .save(outputUri.getPath());