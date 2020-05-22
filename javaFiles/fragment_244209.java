@Around("execution(@Controller * com.exemple.YourService.*(..))")
public Object aroundServiceMethodAdvice(final ProceedingJoinPoint pjp)
   throws Throwable {
   // perform actions before

   return pjp.proceed();

   // perform actions after
}