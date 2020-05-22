public interface Job {
    public void doJob( String arg );
}

public void scheduleJob() {        
    new CronJob(3000, System.out::println);   // would print out what ever arg was past to doJob(arg)
}