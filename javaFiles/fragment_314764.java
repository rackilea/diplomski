SparkSession spark = SparkSession.builder()
    .appName("Simple Application")
    .master("local[*]")
    .getOrCreate();
StructType sensorSchema = new StructType().add("temp", new IntegerType())
        .add("hum01", new IntegerType())
        .add("env", new StructType()
                                .add("lux", new IntegerType())
                                .add("geo", new ArrayType(new FloatType(), false)));
Dataset<Row> socketDF = spark
    .readStream()
    .format("socket")
    .option("host", "localhost")
    .option("port", 9999)
    .schema()
    .load()
    .selectExp("temp, hum01, env");