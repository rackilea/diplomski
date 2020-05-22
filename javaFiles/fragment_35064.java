public interface Job {
    public void doJob( String arg );
}

public void scheduleJob() {        
    new CronJob(3000, arg -> System.out.println("Hello "+arg));
}