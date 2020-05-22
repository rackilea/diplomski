@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) request) {
        @Override
        public HttpSession getSession() {
            return null;
        }
        @Override
        public HttpSession getSession(boolean create) {
            return null;
        }
    }, response);
}