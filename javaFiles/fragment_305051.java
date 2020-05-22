String[] args = new String[]{
    // application name
    "--name",
    "SparkPi-Python",

    "--class",
    "org.apache.spark.deploy.PythonRunner",

    "--py-files",
    SPARK_HOME + "/python/lib/pyspark.zip,"+ SPARK_HOME +"/python/lib/py4j-0.9-src.zip",

    // Python Program
    "--primary-py-file",
    SPARK_HOME + "/examples/src/main/python/pi.py",

    // number of executors
    "--num-executors",  
    "2",

    // driver memory
    "--driver-memory",
    "512m",

    // executor memory
    "--executor-memory", 
    "512m",

    // executor cores
    "--executor-cores", 
    "2",

    // argument 1 to my Spark program
    "--arg",
    slices,

    // argument 2 to my Spark program (helper argument to create a proper JavaSparkContext object)
    "--arg",
    "yarn-cluster"
};