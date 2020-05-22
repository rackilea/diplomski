@WebFilter(urlPatterns = {"/test/*"})
public class SomeInterceptor extends HandlerInterceptorAdapter { 
    @Override 
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception { 
        // ...
        return true; 
    }
}