import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function2;
import scala.Tuple2;

import java.util.List;

public JavaRDD<User> getCombinedUsers(JavaRDD<User> leftUserJavaRDD, JavaRDD<User> rightUserJavaRDD) {

     JavaPairRDD<String, User> leftUserJavaPairRDD =
                leftUserJavaRDD.mapToPair(user -> new Tuple2<>(user.getEmail(), user));

     JavaPairRDD<String, User> rightUserJavaPairRDD =
                rightUserJavaRDD.mapToPair(user -> new Tuple2<>(user.getEmail(), user));

     return leftUserJavaPairRDD
                .union(rightUserJavaPairRDD)
                .reduceByKey(merge).values();
}

/**
 * Reduce Function for merging User with no profession and age information with the one that has profession and age information.
 */
private static Function2<User, User, User> merge =
            (User left, User right) ->
                    new User(left.getName(), left.getEmail(), right.getProfession(), right.getAge());