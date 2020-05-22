public class ApplicationException extends WebApplicationException {
    private static final long serialVersionUID = 1L;

    public ApplicationException(int errorCode, String message) {
        super(Response.status(Response.Status.OK).entity(
                    JsonNodeFactory.instance.objectNode()
                    .put("errorCode", errorCode)
                    .put("errorMessage", message).toString())
                .type(MediaType.APPLICATION_JSON).build());
    }

}