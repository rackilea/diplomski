@Provider
/**
 * AccessDeniedMapper is instantiated by Jersey directly through the "jersey.config.server.provider.packages" setting
 */
public class AccessDeniedMapper implements ExceptionMapper<AccessDeniedException> {
    @Override
    public Response toResponse(AccessDeniedException e) {
        return Response.status(401)
                .build();
    }
}