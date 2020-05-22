@Provider
public class MyExceptionMapper implements ExceptionMapper<Throwable> {


    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(Throwable exception)
    {

         // trigger event
         triggerOnExceptionEvent(request, exception);
    }
...
}