public class VoidResponseHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final String voidResponse = "{}";

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
            final ModelAndView modelAndView) throws IOException {
        // Returned void?
        if (!response.isCommitted()) {
            // Used ModelAndView?
            if (modelAndView != null) {
                return;
            }
            // Access static resource?
            if (DefaultServletHttpRequestHandler.class == handler.getClass()) {
                return;
            }
            response.setStatus(200);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            try (final Writer writer = response.getWriter()) {
                writer.write(voidResponse);
            }
            response.flushBuffer();
        }
    }
}