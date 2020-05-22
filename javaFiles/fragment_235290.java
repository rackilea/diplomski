package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class VehicleActionInterceptor {
  @Before("execution(@de.scrum_master.app.Authenticated * de.scrum_master.app.IVehicle+.*(..))")
  public void beforeAction(JoinPoint thisJoinPoint) {
    System.out.println(thisJoinPoint);
  }
}