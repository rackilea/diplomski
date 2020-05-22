import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;

static SparkConf conf = new SparkConf().setMaster("local").setAppName("simple");
static SparkContext sc = new SparkContext(conf);
static SQLContext sqlContext = new SQLContext(sc);

public static void main(String[] args) {

    Dataset<Row> df = sqlContext.read()
            .format("com.databricks.spark.csv")
            .option("delimiter", " ")
            .option("header", true)
            .option("inferSchema", true)
            .load("path to the input text file");


    sqlContext.udf().register("sums", (Integer a, Integer b, Integer c) -> a+b+c, DataTypes.IntegerType);
    df.registerTempTable("temp");
    sqlContext.sql("SELECT id, sums(a, b, c) AS `(a+b+c)` FROM temp").show(false);

}