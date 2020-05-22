public void beforeJob(JobExecution jobExecution) {      

    int total = dao.getTotalRows();
    jobExecution.getExecutionContext().put("JobComplete", total);

}