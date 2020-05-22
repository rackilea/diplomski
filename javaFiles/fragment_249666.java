public void doFilter(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    chain.doFilter(request, new HttpServletResponseWrapper((HttpServletResponse) response) {
        public String encodeURL(String url) {
            return url;
        }
    });
}