@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    try (YourContext context = YourContext.create(request, response)) {
        chain.doFilter(request, response);
    }
}