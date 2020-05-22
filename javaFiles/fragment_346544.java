public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setAttribute("myFirstAttribute", "MyFirstValueHere");
        return super.preHandle(request, response, handler);
    }

}