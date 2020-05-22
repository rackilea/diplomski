@Autowired
JobDAO jobDAO = null;

@Override
public void beforeJob(JobExecution jobExecution) {
    startTime = new Date();
    System.out.println("Job starts at :"+startTime);
    jobDAO.log()

}