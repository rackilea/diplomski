@Around("cflow(execution(Object ClassThatHasGetResponse.com.package.getResponse(..))) && call(* HttpUtil.postEntity(..))")
public Object GatewayStatus(ProceedingJoinPoint pjp) throws Throwable {
    StopWatch watch = new StopWatch();
    watch.start();
    Object output = pjp.proceed();
    watch.stop();
    log.error("Call took - [" + (watch.getTime()) + "]ms");
    return output;
}