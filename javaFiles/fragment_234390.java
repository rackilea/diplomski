@Provider
public class EmptyBodyCheckFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        if (crc.getEntityStream().available() < 1) {
            crc.abortWith(Response.status(400).entity("Invalid request - empty message body").build());
        }
    }
}