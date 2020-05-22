@Provider 
public class PersistenceMapper implements ExceptionMapper<PersistenceException> { 

    @Override 
    public Response toResponse(PersistenceException arg0) { 
        if(arg0.getCause() instanceof InvalidDataException) {
           return Response.status(Response.Status.BAD_REQUEST).build(); 
        } else {
           ...
        }
    } 

}