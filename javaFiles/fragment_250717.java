package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SampleAspect {
    @Pointcut("call(public * de.scrum_master..*(..)) && !within(SampleAspect)")
    public static void publicMethodCalls() {}

    @Before("publicMethodCalls()")
    public void myPointcut(
        JoinPoint thisJoinPoint,
        JoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart
    ) {
        System.out.println(thisEnclosingJoinPointStaticPart + " -> " + thisJoinPoint);
    }
}