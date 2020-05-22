@Provider
public class SecurityInterceptor 
      implements javax.ws.rs.container.ContainerRequestFilter {
     @Override
     public void filter(ContainerRequestContext requestContext){
       if (not_authenticated){ requestContext.abortWith(response)};
     }
}