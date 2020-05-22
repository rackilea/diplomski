@Aspect
@Component
public class ExecutionTimeLogger {

    private Logger logger;

    public ExecutionTimeLogger() {
        logger = LoggerFactory.getLogger(getClass());
        logger.info("HEY");
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {}

    @Pointcut("execution(* edu.x.y.z.server.web.controller.*Controller.*(..))")
    public void methodPointcut() {}

    @Around("requestMapping() && methodPointcut()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch();
        String name = pjp.getSignature().getName();
        try {
            sw.start();
            return pjp.proceed();
        } finally {
            sw.stop();
            logger.info("STOPWATCH: " + sw.getTime() + " - " + name);
        }
    }
}