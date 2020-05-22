Dataset<Row> newDF = oldDF.map((MapFunction<Row, Row>) row -> {

        String strings[] = row.getString(3).split(","); 
        long[] result = new long[strings.length];
        for (int i = 0; i < strings.length; i++)
        result[i] = Long.parseLong(strings[i]);

        return RowFactory.create(row.getString(0),row.getString(1),result);
    }, RowEncoder.apply(customStructType));