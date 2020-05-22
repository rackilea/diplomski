public static void main(String[] args) {

    SparkConf conf = new SparkConf(true).setMaster("local[4]")
            .setAppName("App_Name")
            .set("spark.cassandra.connection.host", "127.0.0.1")
            .set("spark.cassandra.input.split.size_in_mb","67108864");


    JavaSparkContext sc = new JavaSparkContext(conf);

    JavaRDD<Demo_Bean> empRDD = javaFunctions(sc).cassandraTable("dev",
            "demo");
    System.out.println("Row Count"+empRDD.count());
}