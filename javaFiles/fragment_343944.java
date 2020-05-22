package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MetaAnnotationAspect {
  @Pointcut(
    "@target(de.scrum_master.app.MyAnnotation) || " +
    "@target(de.scrum_master.app.StereotypeAnnotation)"
  )
  public void solutionA() {}

  @Around("execution(* *(..)) && solutionA()")
  public Object executeController(ProceedingJoinPoint point) throws Throwable {
    System.out.println(point);
    return point.proceed();
  }
}