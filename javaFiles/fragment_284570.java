@Around("execution(* testWrappedMethod(..))")
public void aopSample(ProceedingJoinPoint joinPoint) {
  System.out.println("before"); 
  joinPoint.proceed();// this will make the wrapped method execute
  System.out.println("after");
}