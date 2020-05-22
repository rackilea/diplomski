@Around("performance()")
public Object AfterAndPriv(ProceedingJoinPoint joinPoint) {
try {
    System.out.println("Open query");
    return joinPoint.proceed();
} catch (Throwable e) {
    e.printStackTrace();
} finally {
    System.out.println("Close query");
}
}