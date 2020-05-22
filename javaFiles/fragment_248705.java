package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DataSourceConnectionAspect {
  @Before("execution(public java.sql.Connection *.getConnection(..)) && target(javax.sql.DataSource)")
  public void myAdvice(JoinPoint thisJoinPoint) {
    System.out.println(thisJoinPoint);
  }
}