package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// See https://stackoverflow.com/a/48778440/1082681

@Aspect
public class MyAspect {
  @Before("call(* java.util.stream..*(..))")
  public void streamCall(JoinPoint thisJoinPoint) {
    System.out.println(thisJoinPoint);
  }

  @Before("execution(* java.util.function..*(*)) && args(functionArg)")
  public void functionExecution(JoinPoint thisJoinPoint, Object functionArg) {
    System.out.println(thisJoinPoint);
    System.out.println("  " + thisJoinPoint.getTarget().getClass().getSimpleName() + " -> " + functionArg);
  }
}