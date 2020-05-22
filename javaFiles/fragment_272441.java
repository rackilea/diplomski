@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Securable {
  String header() default "session-token";
}

@Provider
@ServerInterceptor
public class ValidationInterceptor implements PreProcessInterceptor, AcceptedByMethod {

  @Context
  private HttpServletRequest servletRequest;

  @Override
  public boolean accept(Class clazz, Method method) {
    return method.isAnnotationPresent(Securable.class);
  }

  @Override
  public ServerResponse preProcess(HttpRequest httpRequest, ResourceMethod resourceMethod) throws Failure,
      WebApplicationException {

    Securable securable =  resourceMethod.getMethod().getAnnotation(Securable.class);
    String headerValue = servletRequest.getHeader(securable.header());

    if (headerValue == null){
      return (ServerResponse)Response.status(Status.BAD_REQUEST).entity("Invalid Session").build();
    }else{
      // Validatation logic goes here
    }

    return null;
  }
}