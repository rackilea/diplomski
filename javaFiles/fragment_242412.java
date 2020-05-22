public class RootResource {
    @Context
    private HttpServletRequest request;

    @Path("/sub/path")
    public SubResource doSomething() {
        final Map<String, String> params = request.getParameterMap();
        // process the parameters 
        // return an instance of your sub resource
    }
}