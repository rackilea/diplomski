@Around("execution(public * *(..)) && @annotation(com.mycompany.MyAnnotation)")
public Object procede(ProceedingJoinPoint call) throws Throwable {
    MethodSignature signature = (MethodSignature) call.getSignature();
    Method method = signature.getMethod();

    MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
}