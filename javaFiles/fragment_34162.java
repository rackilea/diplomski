StructType schema = DataTypes.createStructType(new StructField[] {
            DataTypes.createStructField("field1",  DataTypes.StringType, true),
            DataTypes.createStructField("field2", DataTypes.TimestampType, true),
            DataTypes.createStructField("field3", DataTypes.StringType, true),
            DataTypes.createStructField("field4", DataTypes.StringType, true),
            DataTypes.createStructField("field5", DataTypes.StringType, true)
    });