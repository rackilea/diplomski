import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.util.StatCounter;
import scala.Tuple2;
import scala.Tuple3;

import java.util.Arrays;
import java.util.List;

public class AggregateByKeyStatCounter {

  public static void main(String[] args) {

    SparkConf conf = new SparkConf().setAppName("AggregateByKeyStatCounter").setMaster("local");
    JavaSparkContext sc = new JavaSparkContext(conf);

    List<Tuple2<String, Integer>> myList = Arrays.asList(new Tuple2<>("A", 8), new Tuple2<>("B", 3), new Tuple2<>("C", 5),
            new Tuple2<>("A", 2), new Tuple2<>("B", 8));

    JavaRDD<Tuple2<String, Integer>> data = sc.parallelize(myList);
    JavaPairRDD<String, Integer> pairs = JavaPairRDD.fromJavaRDD(data);

    /* I'm actually using aggregateByKey to perform StatCounter 
       aggregation, so actually you can even have more statistics available */
    JavaRDD<Tuple3<String, Double, Double>> output = pairs
                         .aggregateByKey(
                          new StatCounter(), 
                          StatCounter::merge, 
                          StatCounter::merge)
                         .map(x -> new Tuple3<String, Double, Double>(x._1(), x._2().stdev(), x._2().mean()));

    output.collect().forEach(System.out::println);
  }

}