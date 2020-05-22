import static org.apache.spark.sql.functions.expr;
...
df = df
    .withColumn("time_spent", expr("end - start"))
    .drop("start")
    .drop("end");