@Component
public class ResponseInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
            final ModelAndView modelAndView) throws IOException {
         if (response.getContentType() == null || response.getContentType().equals("")) {
            response.setContentType("application/json");
         }
     }
}