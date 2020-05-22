List<StructField> fieldsObject1 = new ArrayList<>();
for (Field field : MyOwnObject1.class.getDeclaredFields()) {
    fieldsObject1.add(DataTypes.createStructField(
        field.getName(),
        CatalystSqlParser.parseDataType(field.getType().getSimpleName()),
        true)
    );
}
StructType schemaObject1 = DataTypes.createStructType(fieldsObject1);

Dataset<MyOwnObject1> object1DS = spark.read()
    .option("header","true")
    .option("delimiter",";")
    .schema(schemaObject1)
    .csv(pathToFile1)
    .as(encoderObject1);