@Aspect
@Slf4j
@Component
public class TimeCounterAspect {
    @Around("@annotation(methodTimer)")
    public Object logMethodRequests(ProceedingJoinPoint joinPoint, MethodTimer methodTimer)
            throws Throwable {
        Long start = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        Object[] myArgs = joinPoint.getArgs();
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Exception e) {
            throw e;
        } finally {
                log.info("Retrieving timeCost: {} ms in Method: {} args: {}",
                System.currentTimeMillis() - start, methodName, Arrays.deepToString(myArgs));
        }
        return obj;
    }
}