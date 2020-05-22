Dataset<Row> df = store_returns
              .join(date_dim, store_returns.col("sr_returned_date_sk").equalTo(date_dim.col("d_date_sk")))
.where(col("d_year").equalTo("2003"));

df.groupBy("sr_customer_sk","sr_store_sk").agg(sum("sr_return_quantity").alias("ctr_total_return"))
              .select(col("sr_customer_sk").alias("ctr_customer_sk"),
                        col("sr_store_sk").alias("ctr_store_sk"),col("ctr_total_return"))