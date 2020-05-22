package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import de.scrum_master.app.ErrorResponse;
import de.scrum_master.app.Response;

@Aspect
public class ErrorHandler {
  @Around("execution(de.scrum_master.app.Response produceSpecialException(..))")
  public Response handleError(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    try {
      return (Response) thisJoinPoint.proceed();
    }
    catch (Exception e) {
      return new ErrorResponse("aspect handler", e);
    }
  }
}