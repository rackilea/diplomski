@Test
    public void testMysqlToXMLWithParameters() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addString("age", "20").toJobParameters();
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
        Assert.assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);
    }