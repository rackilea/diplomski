import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {

  @Around("@within(retry)")
  public Object typeAspect(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
    return commonAspect(joinPoint, retry);
  }

  @Around("@annotation(retry)")
  public Object methodAspect(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
    return commonAspect(joinPoint, retry);
  }

  private Object commonAspect(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
    System.out.println("Retry is :" + (retry == null ? "null" : retry.value()));
    // ... do your (common) stuff here
    return proceed;
  }

}