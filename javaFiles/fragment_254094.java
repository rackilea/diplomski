public **Object** log(final ProceedingJoinPoint pjp) {
...
    try {
        **return** pjp.proceed(); <<< !
    } catch (Throwable e) {
        e.printStackTrace();
    }    
}