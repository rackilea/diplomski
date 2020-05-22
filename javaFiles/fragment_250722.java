package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SampleAspect {
    @Pointcut("execution(public !static * de.scrum_master..*(..)) && if()")
    public static boolean publicMethodCalls(JoinPoint thisJoinPoint) {
        return Thread.currentThread().getStackTrace()[3].getClassName() != thisJoinPoint.getSignature().getDeclaringTypeName();
    }

    @Before("publicMethodCalls(thisJoinPoint)")
    public void myPointcut(JoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint);
    }
}