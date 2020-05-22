public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse resp = (HttpServletResponse) response;
    HttpServletRequest req = (HttpServletRequest) request;
    resp.setHeader("Cache-Control", "max-age=3600");
    resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
    resp.setHeader("Access-Control-Allow-Origin", "www.myapp.com");
    resp.setHeader("Access-Control-Allow-Credentials", "true");
    if (req.getMethod().equals("OPTIONS")) { 
        resp.flushBuffer();
    } else {
        chain.doFilter(request, resp);
    }
}