val df = spark.read
        .format("com.databricks.spark.csv")
        .option("header", "true") //reading the headers
        .option("mode", "DROPMALFORMED")
        .load("csv/file/path"); //.csv("csv/file/path") //spark 2.0 api

df.show()