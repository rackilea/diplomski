ds = ds
        .select(col("*"), col("struct1.*"))
        .withColumnRenamed("timestamp", "timestamp_")
        .select(
                 col("col1"),
                 col("col2"),
                 struct("timestamp_", "a", "b").as("struct1")
        );