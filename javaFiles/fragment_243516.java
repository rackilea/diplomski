ISparkJobServerClient client = null;
    try {
        client = SparkJobServerClientFactory.getInstance().createSparkJobServerClient("http://ip:8090/");

        Map<String, String> jobParams = new HashMap<String, String>();
        jobParams.put(ISparkJobServerClientConstants.PARAM_APP_NAME, "job-name");
        jobParams.put(ISparkJobServerClientConstants.PARAM_CLASS_PATH, "com.spark.job.WorldCountExample");

        SparkJobResult result = client.startJob("param1=\"data1\", param2=\"data2\"", jobParams);

        SparkJobResult jobResult = client.getJobResult(result.getJobId())

    } catch (SparkJobServerClientException e) {
        System.out.println(e)
    }finally {
        if (client != null) {
            client.stop();
        }