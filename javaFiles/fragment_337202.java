public class MyInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(
        HttpServletRequest request, 
        HttpServletResponse response, Object handler) {

        // your logic
        return true;
    }
}