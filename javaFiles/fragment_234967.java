@Component
@Aspect
public class TimeExecutionProfiler {

    private static final Logger logger = LoggerFactory.getLogger(TimeExecutionProfiler.class);

    @Around("org.mywebapp.util.aspects.SystemArchitecture.businessController()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        logger.info("ServicesProfiler.profile(): Going to call the method: {}", pjp.getSignature().getName());
        Object output = pjp.proceed();
        logger.info("ServicesProfiler.profile(): Method execution completed.");
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("ServicesProfiler.profile(): Method execution time: " + elapsedTime + " milliseconds.");

        return output;
    }

    @After("org.mywebapp.util.aspects.SystemArchitecture.businessController()")
    public void profileMemory() {
        logger.info("JVM memory in use = {}", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}