@Service
public class MyService {

    @Scheduled(cron = "* * * * * *")
    public void runJobs() {
        // Do some operations
    }
}