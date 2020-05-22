public class Hk2CleanupJobListener extends JobListenerSupport {
    public static final String SERVICE_HANDLE_KEY = "hk2_serviceHandle";
    private final Map<String, String> mdcCopy = MDC.getCopyOfContextMap();

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        JobDetail jobDetail = context.getJobDetail();

        ServiceHandle sh = (ServiceHandle) jobDetail.getJobDataMap().get(SERVICE_HANDLE_KEY);
        if (sh == null) {
            if (getLog().isTraceEnabled()) getLog().trace("No serviceHandle found");
            return;
        }

        Class scopeAnnotation = sh.getActiveDescriptor().getScopeAnnotation();
        if (scopeAnnotation == PerLookup.class) {
            if (getLog().isTraceEnabled()) getLog().trace("Destroying job {} after it was executed (Class {})", 
                    jobDetail.getKey(), 
                    jobDetail.getJobClass().getName()
            );
            sh.destroy();
        }

    }

}