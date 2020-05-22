@Aspect
@Component
public class AuthAspect {
  private final TransactionTemplate tx;

  public AuthAspect(TransactionTemplate tx) {
    this.tx = tx;
  }

  @Around("AllRestExecPoint()")
  public Object auth(ProceedingJoinPoint pjp) throws Throwable {

    return tx.execute(ts -> this.executeAuth(pjp));   
  }

  private Object executeAuth(ProceedingJoinPoint pjp) {
    Object returnObject;
    try {
      returnObject  = pjp.proceed();
    } catch (Throwable t) {
      throw new AopInvocationException(t.getMessage(), t);
    }
    if (!checkAuthorization(returnObject)) {
      throw new UnauthException();
    }
    return returnObject;
  }
}