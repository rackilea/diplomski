@Service
public class JobScheduler{

    @Autowired
    JobController controller;

    //Executes each 5000 ms
    @Scheduled(fixedRate=5000)
    public void performJob() {
        controller.doPrintData();
    }
}