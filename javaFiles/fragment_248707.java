package de.scrum_master.aspect;

import javax.sql.DataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class DataSourceConnectionAspect {
  @DeclareParents("de.scrum_master.app.BaseClass")
  private DataSource dataSource;

  @Before("execution(public java.sql.Connection javax.sql.DataSource+.getConnection(..))")
  public void myAdvice(JoinPoint thisJoinPoint) {
    System.out.println(thisJoinPoint);
  }
}