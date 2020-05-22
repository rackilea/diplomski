package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspectX {
    @Before("execution(* *(..)) && !@annotation(de.scrum_master.app.NoLogging)")
    public void logExceptAnnotated(JoinPoint thisJoinPoint) throws Throwable {
        System.out.println(thisJoinPoint);
    }
}