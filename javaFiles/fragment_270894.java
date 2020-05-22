@Before("@annotation(PreAuthorizeAccess)")
public void tessst(JoinPoint joinPoint) throws Throwable {
    for (Object object : joinPoint.getArgs()) {
        int a = 0;
    }
}