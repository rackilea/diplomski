public class SparkSample {
    public static void main(String[] args) {
    //SparkSession
    SparkSession spark = SparkSession
            .builder()
            .appName("SparkSample")
            .config("spark.sql.warehouse.dir", "/file:C:/temp")
            .master("local")
            .getOrCreate();     
    //input data
    List<Tuple2<Integer,String>> inputList = new ArrayList<Tuple2<Integer,String>>();
    inputList.add(new Tuple2<Integer,String>(1, "a"));
    inputList.add(new Tuple2<Integer,String>(1, "b"));
    inputList.add(new Tuple2<Integer,String>(1, "c"));
    inputList.add(new Tuple2<Integer,String>(2, "a"));
    inputList.add(new Tuple2<Integer,String>(2, "b"));          
    //dataset
    Dataset<Row> dataSet = spark.createDataset(inputList, Encoders.tuple(Encoders.INT(), Encoders.STRING())).toDF("c1","c2");
    dataSet.show();     
    //groupBy and aggregate
    Dataset<Row> dataSet1 = dataSet.groupBy("c1").agg(org.apache.spark.sql.functions.collect_list("c2")).toDF("c1","c2");
    dataSet1.show();
    //stop
    spark.stop();
  }
}