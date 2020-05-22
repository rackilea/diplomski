@Provider
    @Produces(MediaType.APPLICATION_JSON)
    public class MyExceptionMapper implements
            ExceptionMapper<MyException> {

        @Override
        public Response toResponse(MyException e) {
            return Response.status(Status.NOT_FOUND).build();
        }

    }