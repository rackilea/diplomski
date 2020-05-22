// you can easily reuse this
@Pointcut("within(com.csc.exceed.uow.*)")
public void myApp() {}

// and this
@Pointcut("execution(* *.*(..))")
public void methodExecution(){}

// but this is the pointcut you are actually matching
@Pointcut("myApp() && methodExecution()")
public void methodExecutionInMyApp(){}

@Before("methodExecutionInMyApp()")
public void logMethodExecutions(JoinPoint jp){
    // your code here
}