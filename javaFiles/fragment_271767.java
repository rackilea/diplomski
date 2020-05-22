public class CustomBadRequestExceptionMapper implements ExceptionMapper<SamplePackOrderBadRequestException> {


@Override
public Response toResponse(final SamplePackOrderBadRequestException exception) {

    if (exception instanceof SamplePackOrderBadRequestException) {

        SamplePackOrderBadRequestException ex
            = (SamplePackOrderBadRequestException) exception;
         return Response
            .status(400)
            .entity(new ErrorBean(400,ex.getMessage,ex.getgetValidationFailures()))
            .build();
    }
    return Response.status(400).build();
}
}