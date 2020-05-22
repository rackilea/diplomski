public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (handler instanceof HandlerMethod) {
        HandlerMethod method = (HandlerMethod)handler;
        if (method.getMethodAnnotation(IpRestricted.class)!=null) {
            if (!request.getRemoteAddr().equals("192.168.1.1")) {
                throw new UnauthorizedException("Ip not authorized");
            }
        }
    }
    [....]
}