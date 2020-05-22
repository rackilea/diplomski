@Service
public class Hk2JobFactory implements JobFactory {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    ServiceLocator serviceLocator;

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {

        JobDetail jobDetail = bundle.getJobDetail();
        Class<? extends Job> jobClass = jobDetail.getJobClass();
        try {
            log.debug("Producing instance of job {} (class {})", jobDetail.getKey(), jobClass.getName());

            ServiceHandle sh = serviceLocator.getServiceHandle(jobClass);
            if (sh != null) {
                Class scopeAnnotation = sh.getActiveDescriptor().getScopeAnnotation();
                if (log.isTraceEnabled()) log.trace("Service scope is {}", scopeAnnotation.getName());
                if (scopeAnnotation == PerLookup.class) {
                    // @PerLookup scope means: needs to be destroyed after execution
                    jobDetail.getJobDataMap().put(SERVICE_HANDLE_KEY, sh);
                }

                return jobClass.cast(sh.getService());
            }

            log.debug("Unable to instantiate job via ServiceLocator, returning unmanaged instance");
            return jobClass.newInstance();

        } catch (Exception e) {
            SchedulerException se = new SchedulerException(
                    "Problem instantiating class '"
                    + jobDetail.getJobClass().getName() + "'", e);
            throw se;
        }

    }

}