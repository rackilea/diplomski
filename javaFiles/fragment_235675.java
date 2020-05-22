@Component(value = "regionAccessValidatorAspect")
@Aspect
public class RegionAccessValidatorAspect {

   @Around(value = "@annotation(com.....RegionAccessValidator)")
   public Object doAccessCheck(final ProceedingJoinPoint jp) throws Throwable {