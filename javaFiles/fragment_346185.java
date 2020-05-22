public  class Scheduler implements Runnable {

@SuppressWarnings("rawtypes")
ScheduledFuture scheduledFuture;

TaskScheduler taskScheduler ;

//this method will kill previous scheduler if exists and will create a new scheduler with given cron expression
public  void reSchedule(String cronExpressionStr){
 if(taskScheduler== null){
        this.taskScheduler = new ConcurrentTaskScheduler();
    }
     if (this.scheduledFuture() != null) {
        this.scheduledFuture().cancel(true);
    }
 this.scheduledFuture = this.taskScheduler.schedule(this, new CronTrigger(cronExpressionStr));
}

@Override
public  void run(){
// task to be performed 
}

//if you want on application to read data on startup from db and schedule the schduler use following method
 @PostConstruct
  public void initializeScheduler() {
    //@postcontruct method will be called after creating all beans in application context
    // read user config map from db 
    // get cron expression created 
    this.reSchedule(cronExp);
  }

}