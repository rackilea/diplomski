@Bean
public HttpRequestHandler odataRequestHandler(ODataHttpHandler handler) {
    return new HttpRequestHandler() {
        public void handleRequest() {
            try {
                handler.process(req, resp);
            } catch (Exception e) {
                log.error("Server Error occurred", e);
                throw new ServletException(e);
            }
        }
    }
}