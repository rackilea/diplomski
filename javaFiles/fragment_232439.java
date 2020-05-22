protected void executeInternal(JobExecutionContext jobContext)
            throws JobExecutionException {
        Client client = new Client();
        client.setClientKey(300);
        sourceDao= (SourceDaoImpl) jobContext.getJobDetail()
                .getJobDataMap().get("sourceDao");
}