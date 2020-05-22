package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnnotationAspect {
  private static final String POINTCUT_METHOD =
    "execution(@org.android10.gintonic.annotation.MyAnnotation * *(..))";

  @Pointcut(POINTCUT_METHOD)
  public void methodToAnnotate() {}

  @Around("methodToAnnotate()")
  public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println(joinPoint);
    joinPoint.proceed();
    return null;
  }
}