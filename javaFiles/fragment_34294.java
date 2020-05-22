package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.SourceLocation;

@Aspect
public class MyAspect {
  @Before("!within(*Aspect) && call(* java.util.stream.Stream.*(..))")
  public void interceptStreamMethods(JoinPoint thisJoinPoint) throws Throwable {
    System.out.println(thisJoinPoint);
    SourceLocation sourceLocation = thisJoinPoint.getSourceLocation();
    System.out.println("  " + sourceLocation.getWithinType());
    System.out.println("  " + sourceLocation.getFileName());
    System.out.println("  " + sourceLocation.getLine());
  }
}