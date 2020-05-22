@Aspect
@Component
public class LoggingAspect implements Ordered {
    @Around("within(@com.mk.cache.LoggedIO *) && execution(* *(..))")
    public Object logAroundPublicMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String wrappedClassName = joinPoint.getSignature().getDeclaringTypeName();
        Logger LOGGER = LoggerFactory.getLogger(wrappedClassName);
        String methodName = joinPoint.getSignature().getName();
    LOGGER.info("LOG by AOP - invoking {}({})", methodName, Arrays.toString(joinPoint.getArgs()));
    Object result = joinPoint.proceed();
    LOGGER.info("LOG by AOP - result of {}={}", methodName, result);
        return result;
    }

    @Override
    public int getOrder() {
        return 1;
    }

}