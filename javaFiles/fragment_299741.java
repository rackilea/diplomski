public class RequestCountFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        Integer requestCount = session.getAttribute("requestCount") == null 0 : session.getAttribute("requestCount");
        session.setAttribute("requestCount", ++requestCount);         
        chain.doFilter(req, res);
    }
    public void init(FilterConfig config) throws ServletException {
        // init code goes here
    }
    public void destroy() {
        // clean up goes here
    }
}