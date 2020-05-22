@Component
public class MyScheduler{
    private Job myImportJob;
    private JobLauncher jobLauncher;

    @Autowired
    public MyScheduler(JobLauncher jobLauncher, @Qualifier("myImportJob") Job myImportJob){
        this.myImportJob = myImoportJob; 
        this.jobLauncher = jobLauncher;
   }

   @Scheduled(fixedRate=9999)
   public void runJob(){
       jobLauncher.run(myImportJob, new JobParameters());
   }
}