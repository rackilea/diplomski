@Component
public class IpCheckingInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Your header-checking code
        String ipAddress = request.getHeader("X-FORWARDED-FOR");  
        if (ipAddress == null) {  
            ipAddress = request.getRemoteAddr();  
        }
        if (<ipAddress not OK>) {
            throw new ForbiddenException("You are not allowed to access this page");
        }
        return true;
    }
}