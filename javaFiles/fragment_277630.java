public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
    TimeZone savedZone = TimeZone.getDefault();
    TimeZone.setDefault(webappZone);
    chain.doFilter(request, response);
    TimeZone.setDefault(savedZone);
}