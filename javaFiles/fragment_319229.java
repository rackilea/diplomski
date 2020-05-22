@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException>  {
  public Response toResponse(BadRequestException ex) {
    return Response.status(404).
      entity(ex.getMessage()).
      type("text/plain").
      build();
  }
}