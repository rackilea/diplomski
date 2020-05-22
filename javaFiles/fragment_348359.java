public class CroISRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter( final ContainerRequestContext requestContext ) throws IOException {

        if (requestContext.getHeaders().getFirst( "accept" ).equals( "*/*,image/webp" )) requestContext.getHeaders().putSingle( "accept", "*/*" );
    }
}