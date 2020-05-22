@Provider
public class CheckHeaderFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext context) {
        if (context.getMethod().toUpperCase().equals("GET")) {
            String header = context.getHeaderString("SomeHeader");
            MultivaluedMap<String, String> headers = context.getHeaders();
            if(notValidHEaders) {
                context.abortWith(Response.status(400).entity("Bad").build());
                // or throw WebApplicationException
            }
        }
    }
}