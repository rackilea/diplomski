package de.scrum_master.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import de.scrum_master.app.MyUtil;

@Aspect
public class MyAspect {
    @Pointcut("adviceexecution() && within(MyAspect)")
    public void myAdvice() {}

    @Pointcut("execution(*..Application.new(..))")
    public void appCreation() {}

    @After("appCreation() && !cflow(myAdvice())")
    public void afterCreation() {
        MyUtil.doSomething();
    }
}