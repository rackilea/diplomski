@Bean
@Primary
public DispatcherServlet dispatcherServlet(WebApplicationContext context) {
    return new DispatcherServlet(context) {
        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
            ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
            super.service(requestWrapper, responseWrapper);
            responseWrapper.copyBodyToResponse();
        }
    };
}