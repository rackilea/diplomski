Process spark = new SparkLauncher()
    .setSparkHome("C:\\spark-1.4.1-bin-hadoop2.6")
    .setAppResource("C:\\spark-1.4.1-bin-hadoop2.6\\lib\\spark-examples-1.4.1-hadoop2.6.0.jar")
    .setMainClass("org.apache.spark.examples.SparkPi").setMaster("yarn-cluster").launch();

InputStreamReaderRunnable inputStreamReaderRunnable = new InputStreamReaderRunnable(spark.getInputStream(), "input");
Thread inputThread = new Thread(inputStreamReaderRunnable, "LogStreamReader input");
inputThread.start();

InputStreamReaderRunnable errorStreamReaderRunnable = new InputStreamReaderRunnable(spark.getErrorStream(), "error");
Thread errorThread = new Thread(errorStreamReaderRunnable, "LogStreamReader error");
errorThread.start();

System.out.println("Waiting for finish...");
int exitCode = spark.waitFor();
System.out.println("Finished! Exit code:" + exitCode);