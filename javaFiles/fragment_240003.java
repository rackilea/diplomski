package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import de.scrum_master.app.SomeResource;

@Component
@Aspect
public class WrapMethodsAspect {
  @Around("execution(* *(..)) && (within(de.scrum_master.app.X+) || within(de.scrum_master.app.Y+))")
  public Object wrapperAdvice(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    System.out.println("Wrapping " + thisJoinPoint);
    try (SomeResource res = new SomeResource()) {
      return thisJoinPoint.proceed();
    }
    finally {
      System.out.println("Unwrapping " + thisJoinPoint);
    }
  }
}