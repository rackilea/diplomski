public class JobInitializer implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger = LoggerFactory.getLogger(JobInitializer.class);

    @Autowired
    DataMiningJobRepository repository;

    @Autowired
    ApplicationJobRepository jobRepository;

    @Autowired
    Scheduler scheduler;

    @Autowired
    JobSchedulerLocator locator;

    @Autowired
    ListableBeanFactory beanFactory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("Job Initilizer started.");

        //TODO: Modify this call to only pull completed & enabled jobs
        for (ApplicationJob applicationJob : jobRepository.findAll()) {
            if (applicationJob.getIsEnabled() && (applicationJob.getIsCompleted() == null || !applicationJob.getIsCompleted())) {
                JobSchedulerUtil.schedule(new JobContext(beanFactory, scheduler, locator, applicationJob));
            }
        }       
    }

}