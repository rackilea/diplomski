public SparkConf sparkConfiguration() {
    SparkConf cfg = new SparkConf();
    File hadoopStubHomeDir = new File(".");

    System.setProperty("hadoop.home.dir", hadoopStubHomeDir.getAbsolutePath());
    cfg.setAppName("ScalaPython")
            .setMaster("local")
            .set("spark.executor.instances", "2");

    return cfg;
}