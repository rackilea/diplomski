public class SparkCassandraRDDApplication {
public static void main(String[] args) {
    SparkConf conf = new SparkConf()
            .setAppName("SparkCassandraRDDApplication")
            .setMaster("local[2]")
            .set("spark.cassandra.connection.host", "127.0.0.1")
            .set("spark.cassandra.connection.port", "9042");

    JavaSparkContext sc = new JavaSparkContext(conf);

    //Read
    JavaRDD<UserData> resultsRDD = javaFunctions(sc).cassandraTable("mykeyspace", "mytable",CassandraJavaUtil.mapRowTo(UserData.class));

    //Print
    resultsRDD.foreach(data -> {
        System.out.println(data.id);
        System.out.println(data.username);
    });

    sc.stop();
  }
}