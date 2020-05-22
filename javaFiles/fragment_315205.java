public class SparkSalarySum {
public static void main(String[] args) {
    SparkConf conf = new SparkConf().setAppName("SparkSalarySum").setMaster("local[2]");
    JavaSparkContext jsc = new JavaSparkContext(conf);
    JavaRDD<String> lines = jsc.textFile("c:\\temp\\test.txt");
    JavaPairRDD<String, Integer> total = lines.flatMap(line -> Arrays.asList(Integer.parseInt(line.split(",")[2].trim())))
            .mapToPair(sal -> new Tuple2<String, Integer>("Total", sal))
            .reduceByKey((x, y) ->  x +  y);
    total.foreach(data -> {
        System.out.println(data._1()+"-"+data._2());
    });
    total.coalesce(1).saveAsTextFile("c:\\temp\\testOut");
    jsc.stop();
  }
}