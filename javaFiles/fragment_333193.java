SparkAppHandle handle = new SparkLauncher()
        .setSparkHome(SPARK_HOME)
        .setJavaHome(JAVA_HOME)
        .setAppResource(SPARK_JOB_JAR_PATH)
        .setMainClass(SPARK_JOB_MAIN_CLASS)
        .addAppArgs("arg1", "arg2")
        .setMaster("yarn-cluster")
        .setConf("spark.dynamicAllocation.enabled", "true")
        .startApplication();