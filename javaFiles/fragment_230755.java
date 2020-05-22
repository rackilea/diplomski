public class RequestsInWorkInterceptor extends HandlerInterceptorAdapter {

    private static final Logger _logger  = LoggerFactory.getLogger(RequestsInWorkInterceptor.class);
    private final AtomicLong counter     = new AtomicLong();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String methodURI = request.getRequestURI();
        long current;
        if("myPathName".equals(methodURI){
            current = counter.incrementAndGet();
            _logger.debug("current {} clients in a queue", current);
        } else {
            current = counter.get(); // just get, no increment
        }

        // +edit: put the count in the request so you can get it in you controller
        request.setAttribute("inQueue", current);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String methodURI = request.getRequestURI();
        if("myPathName".equals(methodURI){
            counter.decrementAndGet();
        }
        super.postHandle(request, response, handler, modelAndView);
    }
}