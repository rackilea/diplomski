public class CustomRequestCycle extends WebRequestCycle{

    public CustomRequestCycle(WebApplication application,
        WebRequest request,
        Response response){
        super(application, request, response);
        String headerValue = request.getHttpServletRequest().getHeader("foo");
        ((MyCustomSession)Session.get()).setFoo(headerValue);
    }

}