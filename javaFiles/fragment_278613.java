//Method before which point cut needs to be set
@Pointcut("execution(* package.name.ClassName.myhobby(..))")
    public void pointCutFunction() {

    }

@Before("pointCutFunction()")
    public Object myAdvice(final ProceedingJoinPoint proceedingJoinPoint)
             {
Object arr[]=proceedingJoinPoint.getArgs();
 System.out.println("value is: " + arr[0]);

}