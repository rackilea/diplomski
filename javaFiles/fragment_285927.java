@Provider
public class NotAllowedMapper
     implements ExceptionMapper< NotAllowedExeption > {

   public Response toResponse(NotAllowedExeption e) {
      return Response.status(Response.Status.NOT_FOUND).build();
   }
}