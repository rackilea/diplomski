@Provider
public class IllegalArgumentExceptionMapper 
             implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException exception) {
        return Response.status(400).entity(exception.getMessage())
                       .type("text/plain").build();
    }
}