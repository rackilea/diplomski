SparkSession.Builder builder = SparkSession.builder().appName("AWESOME");
        builder.config("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        SparkConf conf = new SparkConf().setAppName("AWESOME");
        Class<?>[] classes = new Class[]{org.apache.hadoop.hbase.io.ImmutableBytesWritable.class};
        conf.registerKryoClasses(classes);
        builder.config(conf);
        SparkSession spark = builder.getOrCreate();