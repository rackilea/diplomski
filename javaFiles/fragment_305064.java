SpringApplication app = new SpringApplication(BatchProcessingServiceStarter.class);
app.setWebEnvironment(false); 

ConfigurableApplicationContext ctx=app.run(args);
JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
JobParameters jobParameters = new JobParametersBuilder()
    .addDate("date", new Date())
    .toJobParameters();  

if(!"1".equals(args[0])){       
    jobLauncher.run(ctx.getBean("BatchConfiguration2", Job.class), jobParameters);                   
} else {
    jobLauncher.run(ctx.getBean("BatchConfiguration1",  Job.class), jobParameters);   
}