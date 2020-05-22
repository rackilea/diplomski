import scala.collection.JavaConversions;
import scala.collection.Seq;

import static java.util.Arrays.asList;

Dataset<Row> result = Spark.getSparkSession().table("table_2").join(udp, JavaConversions.asScalaBuffer(asList("col_1","col_2")));`