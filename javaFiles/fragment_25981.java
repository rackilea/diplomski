@Aspect
public class ResourceAspect {

    Logger logger = [...]

    private static final String RESOURCE = "execution(public !static javax.ws.rs.core.Response path.to.resources..*(..)) && @annotation(path.to.HandleMyOwnException)";

    @Around(RESOURCE)
    public Object translateRuntimeException(ProceedingJoinPoint p) throws Throwable {

        try {
            return p.proceed();
        } catch (MyOwnException moe) {
            return Response.status(400).entity(moe.getMsg()).build();
        } catch (Exception e) {   //unexpected exceptions
            logger.debug(e.getMessage);
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

}