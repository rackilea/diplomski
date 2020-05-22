Dataset<Row> people1 = spark.read()
  .option("header", "false")
  .option("delimeter", "!")
  .csv(logFile1);
Dataset<Row> people2 = spark.read()
  .option("header", "false")
  .option("delimeter", "\u00C7")
  .csv(logFile2);

Dataset<Row> people = people1.union(people2);