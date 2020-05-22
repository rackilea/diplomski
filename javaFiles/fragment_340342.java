Dataset<Row> devWindowDataset = messageDataset
  .withWatermark("eventDate", "10 minutes")
  .groupBy(
    functions.col("deviceID"),
    functions.window(functions.col("eventDate"), "10 minutes", "5 minutes"))
  .count();