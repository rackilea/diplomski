Dataset<Row> xmlDS =  spark.read()
        .format("com.databricks.spark.xml")
        .option("rootTag", "RECORD")
        .option("rowTag", "PROP")
        .load("sample.xml");

xmlDS.printSchema();
xmlDS.show(false);