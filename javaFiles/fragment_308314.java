public class HttpCacheFilter extends ShallowEtagHeaderFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        HttpCacheResponseWrapper responseWrapper = new HttpCacheResponseWrapper(response);
        super.doFilterInternal(request, responseWrapper, filterChain);
    }

    private static class HttpCacheResponseWrapper extends HttpServletResponseWrapper {

        public HttpCacheResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public void flushBuffer() throws IOException {
            // NOOP
        }
    }
}