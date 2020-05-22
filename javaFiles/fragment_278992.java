Dataset<MyOwnObject1> object1DS = spark.read()
    .option("header","true")
    .option("delimiter",";")
    .schema(encoderObject1.schema())
    .csv(pathToFile1)
    .as(encoderObject1);