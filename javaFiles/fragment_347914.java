public class CharsetFilter implements Filter {

    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        req.setCharacterEncoding("UTF-8");

        chain.doFilter(req, res);
        String contentType = res.getContentType(); 
        if( contentType !=null && contentType.startsWith("text/html"))
            res.setCharacterEncoding("UTF-8");
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }
}