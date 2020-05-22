public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
    ...
    try {
        chain.doFilter(request, response);
    }
    catch (Exception ex) {
        // your stuff
        ...
        throw new ServletException(ex);
    }
}