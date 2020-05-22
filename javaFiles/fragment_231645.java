public class SparkSortSample {
public static void main(String[] args) {
    //SparkSession
    SparkSession spark = SparkSession
            .builder()
            .appName("SparkSortSample")
            .master("local[1]")
            .getOrCreate();
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    //Sample data
    List<Tuple2<Tuple2<Integer, Integer>, Integer>> inputList = new ArrayList<Tuple2<Tuple2<Integer, Integer>, Integer>>();
    inputList.add(new Tuple2<Tuple2<Integer, Integer>, Integer>(new Tuple2<Integer, Integer>(2, 444), 4444));
    inputList.add(new Tuple2<Tuple2<Integer, Integer>, Integer>(new Tuple2<Integer, Integer>(3, 333), 3333));
    inputList.add(new Tuple2<Tuple2<Integer, Integer>, Integer>(new Tuple2<Integer, Integer>(1, 111), 1111));
    inputList.add(new Tuple2<Tuple2<Integer, Integer>, Integer>(new Tuple2<Integer, Integer>(2, 222), 2222));
    //JavaPairRDD
    JavaPairRDD<Tuple2<Integer, Integer>, Integer> javaPairRdd = jsc.parallelizePairs(inputList);
    //Sorted RDD
    JavaPairRDD<Tuple2<Integer, Integer>, Integer> sortedPairRDD = javaPairRdd.sortByKey(new TupleComparator(), true);
    sortedPairRDD.foreach(rdd -> {
        System.out.println("sort = " + rdd);
    });
    // stop
    jsc.stop();
    jsc.close();
   }
}