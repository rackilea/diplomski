URL resource = Main.class.getResource("GlobalLandTemperaturesByCountry.csv");
    File filePath = Paths.get(resource.toURI()).toFile();

    JavaSparkContext jsc = new JavaSparkContext("local","Java Spark example");
    SQLContext sqlContext = new SQLContext(jsc);

    DataFrame dataFrame = sqlContext.read()
            .format("com.databricks.spark.csv")
            .option("inferSchema", "true")
            .option("header", "true")
            .load(filePath.getAbsolutePath());
    dataFrame.show();