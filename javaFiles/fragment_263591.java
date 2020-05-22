@Autowired
private KNXUtil         knxUtil;

@Autowired
private ScheduleService scheduleService;

@Override
public void executeInternal(JobExecutionContext context) throws JobExecutionException {

    // Adding this autowires everything as needed
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    JobDataMap jobDataMap = context.getMergedJobDataMap();

    String scheduleId = jobDataMap.getString("scheduleId");

    Schedule schedule = scheduleService.get(scheduleId);

    Set<ScheduledAction> actions = schedule.getScheduledActions();

    for (ScheduledAction scheduledAction : actions) {
        scheduledAction.getAction().execute(logger, knxUtil);
    }

}