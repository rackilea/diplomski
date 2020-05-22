@Component
@Aspect
public class TraceAspect {

    private LogRegistry registry;

    @Autowired
    public TraceAspect(LogRegistry registry) {
        this.registry = registry;
    }

    @Around("@annotation(com.collaterate.logging.Traceable)")
    public Object traceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String loggerName = joinPoint.getSignature()
           .getDeclaringType().getCanonicalName() + "." 
              + joinPoint.getSignature().getName();

        LoggingHelper loggingHelper = registry.get(loggerName);
        if (loggingHelper == null) {
            Traceable traceable = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Traceable.class);
            Logger classLog = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
            loggingHelper = getLoggingHelper(traceable, classLog);
            registry.put(loggerName, loggingHelper)
        }

        String methodName = joinPoint.getSignature().getName();
        loggingHelper.log("{}() - started", methodName);
        Object returnVal = joinPoint.proceed();
        loggingHelper.log("{}() - ended", methodName);

        return returnVal;
    }
}