package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AlternativeSolutionAspect {
  @Pointcut("execution(public java.sql.Connection getConnection(..))")
  private static void getConnection() {}

  @Pointcut("within(javax.sql.DataSource+)")
  private static void withinDataSource() {}

  @Pointcut("target(javax.sql.DataSource)")
  private static void targetDataSource() {}

  @Before("withinDataSource() && getConnection()")
  public void interceptStatically(JoinPoint thisJoinPoint) {
    System.out.println("[static] " + thisJoinPoint);
  }

  @Before("!withinDataSource() && getConnection() && targetDataSource()")
  public void interceptDynamically(JoinPoint thisJoinPoint) {
    System.out.println("[dynamic] " + thisJoinPoint);
  }
}