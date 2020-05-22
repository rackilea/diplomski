class ResponseFilter implements ContainerResponseFilter{
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext){
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:9000");
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        headers.add("Access-Control-Allow-Headers", "Content-Type" );
        headers.add("Access-Control-Allow-Credentials", "true" );
        if(requestValidationFailed){
            Response response = Response.status(status).entity(error).build();
            requestContext.abortWith(response);
        }
    }
}