@Aspect
@Component
public class DumpToFileAspect {

  @Around("@annotation(dtf)")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint, DumpToFile dtf) throws Throwable {

    ...
    // I likte to read out a parameter from the annotation...

    System.out.println(dtf.fileName); // will print "fileName"

    Object proceed = joinPoint.proceed();

    ...

    return proceed;
  }
}