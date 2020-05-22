public class SparkCassandraDatasetApplication {
     public static void main(String[] args) {
     SparkSession spark = SparkSession
              .builder()
              .appName("SparkCassandraDatasetApplication")
              .config("spark.sql.warehouse.dir", "/file:C:/temp")
              .config("spark.cassandra.connection.host", "127.0.0.1")
              .config("spark.cassandra.connection.port", "9042")
              .master("local[2]")
              .getOrCreate();

     //Read data
     Dataset<Row> dataset = spark.read().format("org.apache.spark.sql.cassandra")
            .options(new HashMap<String, String>() {
                {
                    put("keyspace", "mykeyspace");
                    put("table", "mytable");
                }
            }).load();
     //Print data
     dataset.show();       
     spark.stop();
   }        
}