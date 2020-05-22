package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import de.scrum_master.app.DynamicValue;

@Aspect
@Configurable
@Component
public class DynamicValueAspect {
    @Pointcut("get(String de.scrum_master.app..*) && @annotation(dynamicValue)")
    public void isDynamicValue(DynamicValue dynamicValue) {}

    @Around("isDynamicValue(dynamicValue)")
    public Object getLocalized(DynamicValue dynamicValue, ProceedingJoinPoint thisJoinPoint) throws Throwable {
        System.out.println(thisJoinPoint);
        System.out.println("    " + dynamicValue);
        return thisJoinPoint.proceed();
    }
}