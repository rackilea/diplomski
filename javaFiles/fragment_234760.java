public class RequestImpl implements Request {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public RequestImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public Response newResponse(Status status) {
        return new ResponseImpl(response, status);
        // Add a boolean responseCreated to avoid creation of multiple responses? Illegal state!
    }

    public String getParameter(String name) { // Just another example of decorated method.
        return request.getParameter(name);
    }

    // ...
}