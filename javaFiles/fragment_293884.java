@Aspect
public class MyAspect{

    @Pointcut(value="execution(public * *(..))")
    public void anyPublicMethod() {
    }

    @Around("anyPublicMethod() && @annotation(catchThis) && args(.., Long ,..)")
    public Object logAction(
        ProceedingJoinPoint pjp, CatchThis catchThis, Long long)
        throws Throwable {

        return pjp.proceed();
    }
}