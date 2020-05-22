public JobController{
    private final StdScheduler scheduler;

    public JobController(StdScheduler scheduler){
        this.scheduler=scheduler;
        }

    public void addJob(String cronExpr){
        CronTrigger trigger = new CronTrigger("name","group");
        trigger.setCronExpression(cronExpr));
        scheduler.scheduleJob(getJobDetails(), trigger);
        }

    public JobDetails getJobDetails(){
        final JobI jobBean = (JobI) applicationContext.getBean("SimpleJob");
        final MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setTargetObject(jobBean);
        jobDetail.setTargetMethod("execute");
        jobDetail.setName("name");
        jobDetail.setGroup("group");
        return (JobDetail) jobDetail.getObject();
        }
    }