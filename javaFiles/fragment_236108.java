@Provider
class JSONParseExceptionMapper implements ExceptionMapper< JsonParseException > {
    @Override
    public Response toResponse(final JsonParseException jpe) {
        // Create and return an appropriate response here
        return Response.status(Status.BAD_REQUEST)
                .entity("Invalid data supplied for request").build();
    }
}