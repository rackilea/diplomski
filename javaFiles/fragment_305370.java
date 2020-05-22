SparkSession spark = SparkSession
.builder()
.appName("org.sparkexample.WordCount")
.master("local[*]") .
.enableHiveSupport()
.getOrCreate();
DataFrame input = spark.read.csv(inputFileName)