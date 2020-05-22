@Aspect("pertypewithin(com.something.*))")
public abstract class TraceAspect {

Logger logger;

@Pointcut
public abstract void traced();

@Pointcut("staticinitialization(*)")
public void staticInit() {
}

@After(value = "staticInit()")
public void initLogger(JoinPoint.StaticPart jps) {
    logger = Logger.getLogger(jps.getSignature().getDeclaringTypeName());
}

@Before(value = "traced()")
public void traceThatOne(JoinPoint.StaticPart jps) {
    logger.log(jps.getSignature().getName());
}
}