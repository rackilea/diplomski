SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("MYApp").getOrCreate();
        Dataset<Row> df = spark
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", Kafka_source)
                .option("subscribe", Kafka_topic)
                .option("startingOffsets", "earliest")
                .option("failOnDataLoss",false)
                .load();
        Dataset<Row> dg = df.selectExpr("CAST(value AS STRING)");
        Dataset<Row> dz = dg.select(
                        from_json(dg.col("value"), DataTypes.createStructType(
                        new StructField[] {
                                DataTypes.createStructField("Name", StringType,true)
                        })).getField("Name").alias("Name")
                        ,from_json(dg.col("value"), DataTypes.createStructType(
                        new StructField[] {
                                DataTypes.createStructField("Age", IntegerType,true)
                        })).getField("Age").alias("Age")
        StreamingQuery queryone = dg.writeStream()
                .format("json")
                .outputMode("append")
                .option("checkpointLocation",Hadoop_path)
                .option("path",Hadoop_path)
                .start();