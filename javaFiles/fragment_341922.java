public class MyJobFactory extends SimpleJobFactory {
    private final MyComponent component;

    @Inject
    public MyJobFactory(MyComponent component) {
        this.component = component;
    }

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        final Job job = super.newJob(bundle, scheduler);
        if (job instanceof MyJob) {
            component.inject((MyJob) job);
        }
        return job;
    }
}