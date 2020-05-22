@Component
public class FollowJobService {

    @Autowired
    private FollowJobRepository followJobRepository;

    @Autowired
    Scheduler scheduler;

    @Autowired
    ListableBeanFactory beanFactory;

    @Autowired
    JobSchedulerLocator locator;

    public FollowJob findByClient(Client client){
        return followJobRepository.findByClient(client);
    }

    public void saveAndSchedule(FollowJob job) {
        job.setJobType(JobType.FOLLOW_JOB);
        job.setCreatedDt(new Date());
        job.setIsEnabled(true);
        job.setIsCompleted(false);

        JobContext context = new JobContext(beanFactory, scheduler, locator, job);
        job.setQuartzGroup(context.getQuartzGroup());
        job.setQuartzName(context.getQuartzName());

        followJobRepository.save(job);

        JobSchedulerUtil.schedule(new JobContext(beanFactory, scheduler, locator, job));
    }
}