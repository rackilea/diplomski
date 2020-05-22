package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspect {
  @Before(
    "execution(* *(..)) && (" +
      "within(@de.scrum_master.app.Annotation2 *) || " +
      "within(@(@de.scrum_master.app.Annotation2 *) *) || " +
      "within(@(@(@de.scrum_master.app.Annotation2 *) *) *)" +
    ")"
  )
  public void myAdvice1(JoinPoint joinPoint) {
    System.out.println(joinPoint);
  }
}