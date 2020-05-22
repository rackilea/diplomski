package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
  @Before("@within(de.scrum_master.app.MyAnnotation) && execution(public !static * *(..))")
  public void adviceAtWithin(JoinPoint thisJoinPoint) {
    System.out.println("[@within] " + thisJoinPoint);
  }

  @Before("@target(de.scrum_master.app.MyAnnotation) && execution(public !static * *(..))")
  public void adviceAtTarget(JoinPoint thisJoinPoint) {
    System.out.println("[@target] " + thisJoinPoint);
  }
}