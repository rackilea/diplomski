public void createControlTask(String name, String id, String freq) throws SchedulerException {
    JobBuilder jobBuilder;
    JobDetail jobDetail;
    TriggerBuilder trigBuilder;
    Trigger trigger = null;
    CronTrigger trig;
    Set<Trigger> triggerList = new HashSet<Trigger>();
    String[] months = null;
    String cronFreq;
    log.info("in createSchedulerTask() for : " + name);
    if ((freq != null) && !(freq.equals("As needed"))) {
        jobBuilder = JobBuilder.newJob(QuraJob.class);
        jobBuilder = jobBuilder.withIdentity(name + "_JOB", Constants.CONTROL_TASK);
        jobBuilder = jobBuilder.usingJobData(Constants.NAME, name);
        jobBuilder = jobBuilder.usingJobData(Constants.ID, id);
        jobBuilder = jobBuilder.usingJobData(Constants.FREQUENCY, freq);
        jobDetail = jobBuilder.build();
        log.info("Job created -- [" + jobDetail.getKey() + "]");
        if(freq.equals(Constants.MONTHLY)){
            months = Constants.MONTHLY_PERIOD;
        }
        if(freq.equals(Constants.QUARTERLY)){
            months = Constants.QUARTERLY_PERIOD;
        }
        if(freq.equals(Constants.ANNUALLY)){
            months = Constants.ANNUALLY_PERIOD;
        }
        if(freq.equals(Constants.HALF_YEARLY)){
            months = Constants.HALF_YEARLY_PERIOD;
        }
        for(int i = 0; i < months.length; i++){
            cronFreq = props.getProperty("quartz.cron."+months[i]);
            trigBuilder = TriggerBuilder.newTrigger();
            trigBuilder = trigBuilder.withIdentity(name + "_TRIGGER_" + i, Constants.CONTROL_TASK);
            trigBuilder = trigBuilder.startNow();
            trigBuilder = trigBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronFreq));
            trigBuilder = trigBuilder.forJob(jobDetail);
            trigger = trigBuilder.build();  
            triggerList.add(trigger);
        }
        if (!scheduler.isStarted()) {
               scheduler.start();
        }
        if(triggerList.size() > 0){
            scheduler.scheduleJob(jobDetail,triggerList,true);
            for(int j=0;j<scheduler.getTriggersOfJob(jobDetail.getKey()).size();j++){
                log.info((scheduler.getTriggersOfJob(jobDetail.getKey()).get(j)).getNextFireTime()+ "" );
            }
        }
    }
    else
        log.info("Freq [" + freq + "] is not a schedulable value. So not scheduling a task for this control");
}