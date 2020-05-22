public class SomeFilter implements .... {

   @Context
   protected F3RequestContext context;

   public void filter(ContainerRequestContext requestContext) {
       HttpServletRequest req =  
            context.getHeader(HttpServletRequest.class, "fabric3.httpRequest");
   }
}