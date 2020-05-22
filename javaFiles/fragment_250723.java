package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.SoftException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SampleAspect {
    @Pointcut("execution(public !static * de.scrum_master..*(..)) && target(callee) && if()")
    public static boolean publicMethodCalls(Object callee, JoinPoint thisJoinPoint) {
        Class<?> callerClass;
        try {
            callerClass = Class.forName(
                Thread.currentThread().getStackTrace()[3].getClassName()
            );
        } catch (Exception e) {
            throw new SoftException(e);
        }
        Class<?> calleeClass = callee.getClass();
        return !callerClass.isAssignableFrom(calleeClass);
    }

    @Before("publicMethodCalls(callee, thisJoinPoint)")
    public void myPointcut(Object callee, JoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint);
    }
}