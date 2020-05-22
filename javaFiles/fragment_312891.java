private Dataset<Row> df = null;

public Dataset getDataframe() {
    df = sparkSession
        .read()
        .format("com.databricks.spark.csv")
        .option("header", false)
        //.option("inferSchema", true)
        .schema(builder)
        .load("src/main/java/resources/test.csv"); //TODO: CMD line arg
        return df;
}