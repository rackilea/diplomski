package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SampleAspect {
    @Pointcut("call(public * de.scrum_master..*(..)) && !within(SampleAspect)")
    public static void publicMethodCalls() {}

    @Before("publicMethodCalls() && target(callee)")
    public void myPointcut(
        Object callee,
        JoinPoint thisJoinPoint,
        JoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart
    ) {
        Object caller = thisJoinPoint.getThis();
        if (caller == callee)
            return;
        System.out.println(thisEnclosingJoinPointStaticPart + " -> " + thisJoinPoint);
        System.out.println("  caller = " + caller);
        System.out.println("  callee = " + callee);
    }
}