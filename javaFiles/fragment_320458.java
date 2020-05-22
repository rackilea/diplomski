public static void main(String[] args) {

    Properties jobParameters = new Properties();
    jobParameters.put("message", "Hello!");

    JobOperator jobOperator = BatchRuntime.getJobOperator();
    jobOperator.start("x98_batch_local.xml", jobParameters);

}