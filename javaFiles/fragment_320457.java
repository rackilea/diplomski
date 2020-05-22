public static void main(String[] args) {

    System.setProperty("JSR-352-BASE-CONTEXT", "x98_batch_local.xml");

    Properties jobParameters = new Properties();
    jobParameters.put("message", "Hello!");

    JobOperator jobOperator = BatchRuntime.getJobOperator();
    jobOperator.start("x98SampleJob", jobParameters);

}