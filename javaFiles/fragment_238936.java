import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SQLContext;
import static org.apache.spark.sql.functions.*;
import org.apache.spark.sql.DataFrame;


public class App {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local");
       JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext= new SQLContext(sc);

       DataFrame df = sqlContext.sql(
            "SELECT CAST('2012-01-01' AS DATE), CAST('2013-08-02' AS DATE)").toDF("first", "second");
        df.select(datediff(df.col("first"), df.col("second"))).show();
    }
}