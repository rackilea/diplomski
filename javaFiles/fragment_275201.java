@Aspect
public SLAAscpet {
    @Around("execution(@com.foo.bar.SLA * *(..))")
    public void aroundSLAMethod(final JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        SLA annotation = signature.getMethod().getAnnotation(SLA.class)
        int maxtime = annotation.maxtime()
        ...
    }
}