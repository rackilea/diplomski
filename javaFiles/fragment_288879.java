@Around("execution(* net.prc.sales.web.controller..*(..)) && @annotation(net.prc.foo.bar.RequestMapping)")
public Object ourAroundAdvice(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    System.out.println("Before " + thisJoinPoint);
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