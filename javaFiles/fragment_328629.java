public void doFilter(ServletRequest servRequest, ServletResponse servResponse, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request   = (HttpServletRequest ) servRequest;
    HttpServletResponse response = (HttpServletResponse) servResponse;


    if (request.getRequestURI().matches("(?i).*(WEB-INF).*")) {
        response.sendError(401, "You are not authorized to fetch this resource");
        return;
    }