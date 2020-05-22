@Around("execution(* net.prc.sales.web.controller..*(..)) && @annotation(requestMapping)")
public Object ourAroundAdvice(ProceedingJoinPoint thisJoinPoint, RequestMapping requestMapping) throws Throwable {
    System.out.println("Before " + thisJoinPoint);
    System.out.println("  Request method = " + requestMapping.method());
    System.out.println("  Request value  = " + requestMapping.value());

    Object result = null;
    try {
        result = thisJoinPoint.proceed();
        System.out.println("After returning " + thisJoinPoint);
        return result;
    } catch (Throwable t) {
        System.out.println("After throwing " + thisJoinPoint);
        throw t;
    }
}