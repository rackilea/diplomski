@Around("execution(* <BASE_PACKAGE>..*.* (..))")
public Object logAll(PreecedingJoinPoint joinPoint) throws Throwable {
    Object result = null;
    Throwable throwable = null;

    final StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    try {
        result = joinPoint.proceed();
    } catch (Throwable t) {
        throwable = t;
    }
    stopWatch.stop();

    if (throwable == null) {
        LOGGER.debug("Executed " + joinPoint.getSignature() + " in " + stopWatch.getTime() + "ms!");
    } else {
        LOGGER.debug("Executed " + joinPoint.getSignature() + " in " + stopWatch.getTime() + "ms! Threw an exception: " + throwable);
        throw throwable;
    }
    return result;
}