package de.scrum_master.aspect;

import de.scrum_master.app.Hello;

public aspect LoggingAspect {
  pointcut methodExecuted() : execution(* *(..)) && @annotation(Hello);

  Object around(): methodExecuted() {
    System.out.println("Hello");
    Object result = proceed();
    System.out.println("world!");
    return result;
  }
}