public class MyInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!request.getMethod().equalsIgnoreCase("POST") && !request.getMethod().equalsIgnoreCase("GET")) {
            // Not a POST/GET - send error and return false
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized Request");
            return false;
        } else {
            return true;
        }
    }


}