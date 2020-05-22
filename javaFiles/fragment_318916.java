@Aspect
public abstract class MyAspect {

  protected abstract pointcut();


  @Before("pointcut()")
  public void myAdviceMethod() {
    // Advice code goes here
  }
}


public class ConcreteAspect extends MyAspect {

  @Pointcut("execution(* com.acme.*.*(..))")
  protected pointcut() {
  )
}