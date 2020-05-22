@Service
public class StartJob extends QuartzJobBean {

    // the DAO
    private NoaJobInstancesDAO njiDAO;

    public void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        init(context.getJobDetail().getJobDataMap(), context.getScheduler()
                    .getContext());
        // some logic here
        njiDAO.create(params);
    }

    private void init(JobDataMap jobContextMap,
            SchedulerContext schedulerContext) {
        // some initialization using the job data map, not interesting for DAOs

        // row that inject the correct DAO
        this.njiDAO = (NoaJobInstancesDAO) schedulerContext
                .get("noaJobInstancesDAO");
    }
}