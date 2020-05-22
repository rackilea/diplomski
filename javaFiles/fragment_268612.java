@Provider
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(InvalidInputException e) {

        ResponseBuilder rb = Response.status(Status.BAD_REQUEST);

        rb.entity(e.getErrors());
        return rb.build();   
    }
}