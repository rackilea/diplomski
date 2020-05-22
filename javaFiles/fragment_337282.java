@Pointcut("@target(someAnnotation)")
public void targetsSomeAnnotation(@SuppressWarnings("unused") SomeAnnotation someAnnotation) {/**/}

@Around("targetsSomeAnnotation(someAnnotation) && execution(* *(..))")
public Object aroundSomeAnnotationMethods(ProceedingJoinPoint joinPoint, SomeAnnotation someAnnotation) throws Throwable {
    ... your implementation..
}