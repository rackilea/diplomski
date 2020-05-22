@Around("@annotation(com.example.AllParametersRequired.class)")
public Object throwExceptionOnMissingParameters(ProceedingJoinPoint pjp) throws Throwable {
      int nullCount = Arrays.stream(pjp.getArgs()).filter( o -> o == null).count();
      if (nullCount > 0) throw new RuntimeException("Null is not allowed.);
      return pjp.proceed();
}