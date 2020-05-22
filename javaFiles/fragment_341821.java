@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

 @Override
 public boolean preHandle(HttpServletRequest request, 
        HttpServletResponse response, Object object) throws Exception {
    System.out.println("we are Intercepting the Request");
    return true;
 }

 @Override
 public void postHandle(HttpServletRequest request, HttpServletResponse response, 
        Object object, ModelAndView model)
        throws Exception {
    System.out.println("request processing "
            + "completed by @RestController");

 }

 @Override
 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
        Object object, Exception arg3)
        throws Exception {
    System.out.println("afterCompletion Request Completed");
 }
}