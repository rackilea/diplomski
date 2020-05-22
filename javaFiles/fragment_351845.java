@Around("methodsWithURI()")
public void aroundMethodsWithURI(ProceedingJoinPoint joinpoint){
    for(Object objArg: joinpoint.getArgs()){
        if (objArg instanceof URI){
            System.out.println(objArg);
        }
    }
}