package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;

import ua.com.alistratenko.dao.UserDaoImp;

//@Component
@Aspect
public class DaoSessionLifeCycle {
  @Around("execution(public * listUsers(..)) && target(dao)")
  public Object openSession(ProceedingJoinPoint thisJoinPoint, UserDaoImp dao) throws Throwable {
    try {
      System.out.println("Creating session");
      dao.setSession(dao.getSessionFactory().openSession());
      System.out.println("Calling " + thisJoinPoint.getSignature());
      return thisJoinPoint.proceed();
    }
    finally {
      try {
        System.out.println("Closing session");
        dao.getSession().close();
      }
      catch (Exception e) {}
    }
  }
}