@Pointcut ("@annotation(path.to.my.CustomAnnotation)")
public void actionAnnotatedPointCut() {}

@Around("actionAnnotatedPointCut()")
public Object doAround(ProceedingJoinPoint pjp) {
    ...
}