protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.error("Result Processing executed");
        List<Object[]> lstOfExams = examService.getExamEntriesForProcessingResults();
        String timeZone = messageService.getMessage("org.default_timezone", null, Locale.getDefault());
        int cores = Runtime.getRuntime().availableProcessors();
        if(lstOfExams!=null&&!lstOfExams.isEmpty()){
            ThreadPoolTaskExecutor threadPoolExecuter = new ThreadPoolTaskExecutor();
            threadPoolExecuter.setCorePoolSize(cores);
//          threadPoolExecuter.setMaxPoolSize(Integer.MAX_VALUE);
            threadPoolExecuter.setBeanName("ThreadPoolTaskExecutor");
//          threadPoolExecuter.setQueueCapacity(Integer.MAX_VALUE);
            threadPoolExecuter.setQueueCapacity(lstOfExams.size()+10);
            threadPoolExecuter.setThreadNamePrefix("ThreadForUpdateExamResult");
            threadPoolExecuter.setWaitForTasksToCompleteOnShutdown(true);
            threadPoolExecuter.setThreadPriority(10);
            threadPoolExecuter.initialize();


            for(Object[] obj : lstOfExams){
                if(StringUtils.isNotBlank((String)obj[2]) ){
                    timeZone = obj[2].toString();
                }
                try {
                    Userexams userexam=examService.findUserExamById(Long.valueOf(obj[0].toString()));
                    if(userexam.getExamresult()==null){
                        UpdateUserExamDataThread task=new UpdateUserExamDataThread(obj,timeZone,testEvaluator);
//                      threadPoolExecuter.submit(task);
                        threadPoolExecuter.execute(task);
                    }
//                  testEvaluator.generateTestResultAsPerEvaluator(Long.valueOf(obj[0].toString()), obj[4].toString(), obj[3]==null?null:obj[3].toString(),timeZone ,obj[5].toString() ,obj[1].toString()); 
//                  logger.error("Percentage Marks:::::"+result.getPercentageCatScore());
                } catch (Exception e) {
                    logger.error("Exception at ResultProcessingJob extends QuartzJobBean executeInternal(JobExecutionContext context) throws JobExecutionException",e);
                    continue;
                }
            }
                threadPoolExecuter.shutdown();
        }
}