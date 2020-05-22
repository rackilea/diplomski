package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SampleAspect {
    @Around("execution(* doSomething(int)) && args(number)")
    public Object intercept(final ProceedingJoinPoint thisJoinPoint, int number) throws Throwable {
        System.out.println(thisJoinPoint + " -> " + number);
        if (number < 0)
            return thisJoinPoint.proceed(new Object[] { -number });
        if (number > 99)
            throw new RuntimeException("oops");
        return thisJoinPoint.proceed();
    }
}