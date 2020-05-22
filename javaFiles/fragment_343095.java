public class JsonDataReader {

    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().appName("Java Spark SQL basic example")
                .master("spark://192.168.0.2:7077").getOrCreate();

//      JavaRDD<Tuple2<String, String>> javaRDD = spark.sparkContext().wholeTextFiles("C:\\\\Users\\\\phyadavi\\\\LearningAndDevelopment\\\\Spark-Demo\\\\data1\\\\alert.json", 1).toJavaRDD();

        Seq<String> joinColumns = scala.collection.JavaConversions
                  .asScalaBuffer(Arrays.asList("partyId","sourcePartyId", "sourceSubPartyId", "wfid", "generatedAt", "collectorId"));

        Dataset<Row> df = spark.read().option("multiLine",true).option("mode", "PERMISSIVE")
                .json("C:\\Users\\phyadavi\\LearningAndDevelopment\\Spark-Demo\\data1\\alert.json");
        Dataset<Row> df2 = spark.read().option("multiLine", true).option("mode", "PERMISSIVE")
                .json("C:\\Users\\phyadavi\\LearningAndDevelopment\\Spark-Demo\\data1\\contract.json");

        Dataset<Row> finalDS = df.join(df2, joinColumns,"inner");
        finalDS.write().mode(SaveMode.Overwrite).json("C:\\Users\\phyadavi\\LearningAndDevelopment\\Spark-Demo\\data1\\final.json");

//      List<Tuple2<String, String>> collect = javaRDD.collect();
//      collect.forEach(x -> {
//          System.out.println(x._1);
//          System.out.println(x._2);
//      });

    }

}