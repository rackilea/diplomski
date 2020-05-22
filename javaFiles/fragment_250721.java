package de.scrum_master.aspect;

public aspect DemoAspect {
    pointcut publicMethodCalls() :
        execution(public !static * de.scrum_master..*(..)) &&
        if(Thread.currentThread().getStackTrace()[3].getClassName() != thisJoinPointStaticPart.getSignature().getDeclaringTypeName()); 

    before() : publicMethodCalls() {
        System.out.println(thisJoinPoint);
    }
}