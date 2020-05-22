@Aspect
public class LoggingAspect {

  @AfterThrowing(
   pointcut = "execution(* package.addCustomerThrowException(..))",
   throwing= "error")
  public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
    //...
  }
}