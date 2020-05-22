SparkConf conf = new SparkConf();
conf.setAppName("YOUR APP");
//other config like conf.setMaster("YOUR MASTER");
JavaSparkContext ctx = new JavaSparkContext(conf);

//and then
JavaRDD<Row> testRDD = ctx.parallelize(list);