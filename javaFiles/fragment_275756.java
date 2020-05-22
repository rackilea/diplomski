@Provider
public class QueryParametersFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String query = requestContext.getUriInfo().getRequestUri().getQuery();

        if (query != null && !query.isEmpty()) {
            requestContext.abortWith(
                Response.status(Status.BAD_REQUEST)
                        .entity("Parameters not allowed in the query string")
                        .build());
        }
    }
}