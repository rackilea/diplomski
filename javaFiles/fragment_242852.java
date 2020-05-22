Dataset<Row> test = spark.read()
.format("com.databricks.spark.csv")
.option("header", "true")
.option("delimiter", "|")
.option("quote", " ")
.load(filePath);