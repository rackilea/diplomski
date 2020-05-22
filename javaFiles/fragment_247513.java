package de.scrum_master.aspect;

import java.lang.reflect.Method;
import org.aspectj.lang.reflect.MethodSignature;
import de.scrum_master.app.AccessControl;

public aspect AccessControlAspect {
  pointcut makeAccessControl(AccessControl accessControl) :
    @annotation(accessControl) &&
    execution(* *(..));

  before(AccessControl accessControl) : makeAccessControl(accessControl) {
    Method method = ((MethodSignature) thisJoinPoint.getSignature()).getMethod();
    String accessID = accessControl.accessID();
    System.out.println(thisJoinPoint);
    System.out.println("  method   = " + method);
    System.out.println("  accessID = " + accessID);
  }

}