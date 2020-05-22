package de.scrum_master.aspect;

import java.util.Random;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import de.scrum_master.app.Identity;

@Aspect
public class IdSetterAspect {
  private static final Random RANDOM = new Random();

  @Before("execution(* de.scrum_master..save(..)) && args(identity)")
  public void beforeAdvice(JoinPoint thisJoinPoint, Identity identity) {
    System.out.println(thisJoinPoint);
    System.out.println("  Old ID = " + identity.getId());
    identity.setId(RANDOM.nextInt(1000));
    System.out.println("  New ID = " + identity.getId());
  }
}