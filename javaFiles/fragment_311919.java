package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import de.scrum_master.app.DynamicValue;

@Aspect
@Configurable
@Component
public class DynamicValueAspect {
    @Pointcut("get(* de.scrum_master.app..*) && @annotation(dynamicValue)")
    public void isDynamicValue(DynamicValue dynamicValue) {}

    @AfterReturning(pointcut = "isDynamicValue(dynamicValue)", returning = "field")
    public void getLocalized(DynamicValue dynamicValue, int field, JoinPoint thisJoinPoint) throws Throwable {
        System.out.println(thisJoinPoint);
        System.out.println("    " + dynamicValue);
    }
}