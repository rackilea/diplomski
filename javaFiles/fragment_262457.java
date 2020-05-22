@Provider
public class CorsRequestFilter implements ContainerRequestFilter {

   @Override
   public void filter(final ContainerRequestContext requestContext)
         throws IOException {
      if (requestContext.getRequest().getMethod().equals(HttpMethod.OPTIONS)) {
         requestContext.abortWith(Response.status(Response.Status.OK).build());
      }
   }
}

@Provider
public class CorsResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(final ContainerRequestContext requestContext,
            final ContainerResponseContext responseContext) throws IOException {
        final MultivaluedMap<String, Object> headers = responseContext.getHeaders();

        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Auth-Token");
    }

}