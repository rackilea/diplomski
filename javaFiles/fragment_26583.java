import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class AfterThrowingExample {

  @AfterThrowing(
     pointcut="com.xyz.myapp.A.someOperation()"
     throwing="ex")
  public void doRecoveryActions(IOException ex) {
    // ...
  }
}