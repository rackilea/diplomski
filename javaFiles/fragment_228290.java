import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class InitializeConnectionPool extends Job {
    @Override
    public void doJob() {
        //initialize your connection pools here, storing them in a static variable
    }
}