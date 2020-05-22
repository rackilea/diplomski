@Aspect
public class Interceptor {
    /**
     * Matches constructor testMaven.testing.
     * <p/>
     * *NOTE:* This will only work when class compiled with aspectj.
     */
    @After("execution(* testMaven.testing.new(..))")
    public void constructorInvocation(JoinPoint joinPoint)
            throws Throwable {
        testing instance = (testing) joinPoint.getTarget();
        instance.aa(2);
    }
}