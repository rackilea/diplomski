package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SkipValidationAspect {
  @Around("execution(@de.scrum_master.app.MyAnnotation(message=\"msg\") boolean *(..))")
  public boolean skipValidation(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    return false;
  }
}