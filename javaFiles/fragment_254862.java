public class CacheControlInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            //Example below: set your Cache-Control, expires, pragma headers here
        response.setHeader("Cache-Control", "private");

        return true;
    }
}