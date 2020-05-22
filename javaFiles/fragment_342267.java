public class Main {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf(true).setAppName("your_app_name_here").setMaster("local[1]");
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        Tuple2<String, String>[] array = (Tuple2<String, String>[]) new Tuple2[]{new Tuple2<>("A", "list"), new Tuple2<>("A", "set"), new Tuple2<>("B", "map")};
        JavaPairRDD<String, String> usersWithCollectionType = sparkContext
                .parallelize(Arrays.asList(array))
                .mapToPair(e -> new Tuple2<>(e._1(), e._2()));
        usersWithCollectionType.collect();

        Tuple2<String, Integer>[] array2 = (Tuple2<String, Integer>[]) new Tuple2[]{new Tuple2<>("list", 5), new Tuple2<>("set", 7), new Tuple2<>("map", 1)};
        JavaPairRDD<String, Integer> collectionTypeWithSize = sparkContext
                .parallelize(Arrays.asList(array2))
                .mapToPair(e -> new Tuple2<>(e._1(), e._2()));

        JavaPairRDD<String, Integer> combined = findTotalSizePerUser(usersWithCollectionType, collectionTypeWithSize);

        combined.collect()
                .forEach(System.out::println);
    }

    private static JavaPairRDD<String, Integer> findTotalSizePerUser(JavaPairRDD<String, String> usersWithCollectionType,
                                                                     JavaPairRDD<String, Integer> collectionTypeWithSize) {
        return usersWithCollectionType
                .mapToPair(Tuple2::swap)
                .join(collectionTypeWithSize)
                .mapToPair(p -> new Tuple2<>(p._2()._1(), p._2()._2()))
                .reduceByKey((a, b) -> a + b);
    }
}