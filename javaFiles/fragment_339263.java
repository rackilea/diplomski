@AfterThrowing(pointcut = "execution( * com.company..*(..)) and !execution( * com.company.*.action..*(..))", throwing = "throwable")
public void logException(JoinPoint joinPoint,Throwable throwable)
{
    Logger logger = Logger.getLogger(joinPoint.getTarget().getClass());
    String className = joinPoint.getTarget().getClass().getCanonicalName();
    logger.error(className + " :: " + joinPoint.getSignature().getName() + " :: " + "Exception", throwable);
}