@Autowired
private StatsDao statsDao;

@Pointcut("execution(Event EventService+.getById(Integer))")
private void gettingEvent() {}

@AfterReturning(pointcut = "gettingEvent()", returning = "retVal")
public void countGettingEvent(JoinPoint joinPoint, Object retVal) {
    Integer eventId = (Integer) joinPoint.getArgs()[0];
    if (eventId != null && retVal != null) {
        GettingEventsStats gettingEventStats = statsDao.getGettingEventStats(eventId);
        if (gettingEventStats == null) {
            statsDao.createGettingEventCounter(eventId);
        } else {
            statsDao.updateGettingEventCounter(eventId);
        }
    }
}