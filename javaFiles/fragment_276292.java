public class RequestResponseHolder {

    private static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
    private static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<HttpServletResponse>();


    public static void setRequestResponse(HttpServletRequest request, HttpServletResponse response) {
        requestHolder.set(request);
        responseHolder.set(response);
    }

    public static HttpServletRequest getServletRequest(){
         return requestHolder.get();
    }

    public static HttpServletResponse getServletResponse()  {
        return responseHolder.get();
    }

    public static void clear() {
        requestHolder.remove();
        responseHolder.remove();
    }
}