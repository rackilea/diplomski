public class BlockHttpFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if(req.isSecure() && checkHttpEnpointPath(req)){
            chain.doFilter(request, response);
        } else {
            HttpServletResponse res = (HttpServletResponse)response;
            res.sendError(403);
         }
    }

    public void destroy() {
        //we can close resources here
    }

}