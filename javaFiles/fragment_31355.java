Dataset<Row> df = spark.read().format("csv").option("header", "true")
                .load("...");

Map<String,String> collect_MAP =  Arrays.stream(df.columns())
            .filter(f -> !f.equals("id"))
            .collect(Collectors.toMap(f -> f,f -> "collect_set"));


     df.groupBy("id").agg(collect_MAP).show(false);