@Around("execution(* *(.., @aspectjtest.ReplaceFooBar (*), ..))")
public Object replaceFooBar(ProceedingJoinPoint pjp) throws Throwable {
    //get original args
    Object[] args = pjp.getArgs();

    //get all annotations for arguments
    MethodSignature signature = (MethodSignature) pjp.getSignature();
    String methodName = signature.getMethod().getName();
    Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
    Annotation[][] annotations;
    try {
        annotations = pjp.getTarget().getClass().
                getMethod(methodName, parameterTypes).getParameterAnnotations();
    } catch (Exception e) {
        throw new SoftException(e);
    }

    //Find annotated argument
    for (int i = 0; i < args.length; i++) {
        for (Annotation annotation : annotations[i]) {
            if (annotation.annotationType() == ReplaceFooBar.class) {
                Object raw = args[i];
                if (raw instanceof String) {
                    // and replace it with a new value
                    args[i] = ((String) raw).replaceAll("foo", "bar");
                }
            }
        }
    }
    //execute original method with new args
    return pjp.proceed(args);
}