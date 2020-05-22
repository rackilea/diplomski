@Provider
public class CorsExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        ResponseBuilder responseBuilder = Response.serverError();
        responseBuilder.header("Access-Control-Allow-Origin", "*");
        responseBuilder.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, auth-token");
        responseBuilder.header("Access-Control-Allow-Credentials", "true");
        responseBuilder.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        responseBuilder.header("Access-Control-Max-Age", "1209600");
        return responseBuilder.build();
    }

}