package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import static java.lang.System.currentTimeMillis;

@Aspect
public class TimingAspect {
  @Around("execution(* *(..)) && cflow(execution(* de.scrum_master.app.TextTransformer.*(..)))")
  public Object measureExecutionTime(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    long startTime = currentTimeMillis();
    Object result = thisJoinPoint.proceed();
    System.out.println(thisJoinPoint + " -> " + (currentTimeMillis() - startTime) + " ms");
    return result;
  }
}