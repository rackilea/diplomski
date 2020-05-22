package org.kayd;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectTest {
  @Pointcut("execution(* *(..))")
  public void defineEntryPoint() {}

  @Before("defineEntryPoint()")
  public void log(JoinPoint joinPoint) {
    System.out.println("Before advice on " + joinPoint);
  }

  @After("execution(org.kayd.Client.data())")
  public void afterAdvice(JoinPoint joinPoint) {
    System.out.println("After advice on " + joinPoint);
  }
}