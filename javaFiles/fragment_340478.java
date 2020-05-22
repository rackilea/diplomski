StructType schemaList = new StructType(new StructField[]{new StructField("labelToFind", DataTypes.StringType, false, Metadata.empty())});

 List<Row> listStrings = Arrays.asList(
                RowFactory.create("40504"),
                RowFactory.create("630-0746"),
                RowFactory.create("477-7444"),
                RowFactory.create("444-4444"));

 Dataset<Row>listDataset = sqlContext.createDataFrame(listStrings, schemaList);