final String sparkHome = "/usr/local/Cellar/apache-spark/2.3.2";
SparkConf conf = new SparkConf()
        .setMaster("local[*]")
        .setAppName("spark-example")
        .setSparkHome(sparkHome + "/libexec");

SparkSession spark = SparkSession.builder().config(conf).getOrCreate();
Dataset<Row> df = spark.read().textFile(sparkHome + "/README.md")
        .flatMap(line -> Arrays.asList(line.split(" ")).iterator(), Encoders.STRING())
        .filter(s -> !s.isEmpty())
        .map(word -> new Tuple2<>(word.toLowerCase(), 1L), Encoders.tuple(Encoders.STRING(), Encoders.LONG()))
        .toDF("word", "count")
        .groupBy("word")
        .sum("count").orderBy(new Column("sum(count)").desc()).withColumnRenamed("sum(count)", "_cnt");

df.show(false);