@Aspect
public class AroundExample {

  @Around("some.pointcut()")
  public Object doSomeStuff(ProceedingJoinPoint pjp) throws Throwable {

    Object[] args = joinPoint.getArgs(); // change the args if you want to
    Object retVal = pjp.proceed(args); // run the actual method (or don't)
    return retVal; // return the return value (or something else)
  }

}