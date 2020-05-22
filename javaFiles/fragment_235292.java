package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import de.scrum_master.app.Authenticated;

@Aspect
public class VehicleActionInterceptor {
  @Before("execution(* de.scrum_master.app.IVehicle+.*(..)) && @annotation(authenticated)")
  public void beforeAction(JoinPoint thisJoinPoint, Authenticated authenticated) {
    System.out.println(thisJoinPoint + " -> " + authenticated);
  }
}