@Aspect
@Component
public class RequiresAccountWrapperAspect {

  @Autowired
  private HttpServletRequest request;

  private RequiresAccountAspect requiresAccountAspect = new RequiresAccountAspect();

  @Around("@annotation(com.example.demo.components.RequiresAccountWrapper)")
  public Object checkIfRequiresAccount(ProceedingJoinPoint joinPoint) throws Throwable {
    String requestURL = request.getRequestURL().toString();
    if (requestURL.startsWith("http://localhost")) {
      requiresAccountAspect.checkAccount(joinPoint);
    }
    return joinPoint.proceed();
  }
}