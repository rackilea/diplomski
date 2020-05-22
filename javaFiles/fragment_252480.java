@Aspect
@Component
public class FilteredExceutionAspect{

  @Around("@annotion(filterAnnotation)")
  public void filter(ProceedingJoinPoint pjp , FilteredExecution filterAnnotation){
     boolean shouldExecute = checkShouldExecute(filterAnnotation);
     if(shouldExecute){
        pjp.proceed();
     }
  }

  private boolean checkShouldExecute(FilteredExecution filterAnnotation){
     //use reflection to invoke the ExecutionFilter specified on filterAnnotatoon
  }