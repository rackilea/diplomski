@Aspect
public class LoggingAspect{

    @Pointcut("execution(* com.mycompany.myproject.*.*(..))")
    public void methodToLog(){
    };

    @Around("methodToLog()")
    public Object logMethod(final ProceedingJoinPoint joinPoint) throws Throwable{
        final StaticPart staticPart = joinPoint.getStaticPart();
        final String sig =
            "" + staticPart.getSignature() + " with args: "
                + Arrays.deepToString(joinPoint.getArgs());
        System.out.println("Entering method " + sig);
        final Object result = joinPoint.proceed();
        System.out.println("Leaving method " + sig);
        return result;
    }

}