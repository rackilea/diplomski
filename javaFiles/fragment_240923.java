public class PrintFilter implements ContainerResponseFilter, ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {


        System.out.println("Response body: " + responseContext.getEntity());
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String string = IOUtils.toString(requestContext.getEntityStream());
        System.out.println("request body: " + string);
    }


}