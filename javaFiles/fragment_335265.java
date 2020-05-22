import static org.apache.spark.sql.functions.*;

new_log_df.cache().withColumn("timePeriod", encodeUDF(col("START_TIME"))) 
  .groupBy("timePeriod")
  .agg(
     mean("DOWNSTREAM_SIZE").alias("Mean"), 
     stddev("DOWNSTREAM_SIZE").alias("Stddev"),
     count(lit(1)).alias("Num Of Records")
   )
  .show(20, false)