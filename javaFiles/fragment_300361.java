import org.apache.spark.sql.Row;
import org.apache.spark.sql.Dataset;

Dataset<Row> df = spark.read().format("csv")
                      .option("sep", ";")
                      .option("header", "true") //or "false" if no headers
                      .load("filename.csv");