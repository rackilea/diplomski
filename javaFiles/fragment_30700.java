package de.scrum_master.aspect;

import java.net.HttpURLConnection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
  @Pointcut("call(* java.net.HttpURLConnection.connect()) && target(connection)")
  public void connectMethodCall(HttpURLConnection connection) {}

  @Around("connectMethodCall(connection)")
  public Object onGetUrlConnection(ProceedingJoinPoint pjp, HttpURLConnection connection) throws Throwable {
    connection.setRequestProperty("From", "user@example.com");
    return pjp.proceed();
  }
}