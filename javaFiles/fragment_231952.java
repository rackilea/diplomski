import org.apache.spark.sql.functions.{expr, col}

val df = Seq(("2012-04-05", 6))
  .toDF("date", "days")
  .withColumn("date", col("date").cast("date"))

df.select(expr("date_add(date, days)"))