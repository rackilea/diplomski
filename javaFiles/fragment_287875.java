@Provider
public class YourFancyExceptionMapper 
                implements ExceptionMapper <YourFancyException> {
    @Override
    public Response toResponse(YourFancyException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                        .entity(exception.getMessage()).build();
    }
}