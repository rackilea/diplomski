json.foreachRDD(new VoidFunction<JavaRDD<String>>() {
        @Override
        public void call(JavaRDD<String> rdd) {
            if(!rdd.isEmpty()){
                Dataset<Row> data = spark.read().json(rdd).select("sensors");
                data.printSchema();
                data.show(false);
                //DF in table
                Dataset<Row> df = data.select( org.apache.spark.sql.functions.explode(org.apache.spark.sql.functions.col("sensors"))).toDF("sensors").select("sensors.s","sensors.d");
                df.show(false);
            }
        }
    });