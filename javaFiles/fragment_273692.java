@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<AccessLocalException> {

   @Override
   public Response toResponse(AccessLocalException exception) {
      return Response.status(Response.Status.NOT_FOUND).build();
   }
}