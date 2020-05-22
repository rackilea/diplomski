package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MetaAnnotationAspect {
  @Pointcut(
    "within(@de.scrum_master.app.MyAnnotation *) || " +
    "within(@(@de.scrum_master.app.MyAnnotation *) *) || " +
    "within(@(@(@de.scrum_master.app.MyAnnotation *) *) *)"
  )
  public void solutionB() {}

  @Around("execution(* *(..)) && solutionB()")
  public Object executeController(ProceedingJoinPoint point) throws Throwable {
    System.out.println(point);
    return point.proceed();
  }
}