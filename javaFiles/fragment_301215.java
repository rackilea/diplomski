SparkSession spark = SparkSession
    .builder()
    .master("local[*]")
    .appName("My Spark App")
    .getOrCreate();

spark.sparkContext.hadoopConfiguration.set("fs.s3n.impl", "org.apache.hadoop.fs.s3native.NativeS3FileSystem")
spark.sparkContext.hadoopConfiguration.set("fs.s3n.awsAccessKeyId", "<my-key>")
spark.sparkContext.hadoopConfiguration.set("fs.s3n.awsSecretAccessKey", "<my-secret-key>")