public class LogInterceptor implements HandlerInterceptor {

     @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
          String path = (String)request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
          System.out.println("path : " + path);
        return true;
      }
}