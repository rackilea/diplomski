public class StatusReportingFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        StatusExposingServletResponse response = new StatusExposingServletResponse((HttpServletResponse)res);
        chain.doFilter(req, response);
        int status = response.getStatus();
        // report
    }

    public void init(FilterConfig config) throws ServletException {
        //empty
    }

    public void destroy() {
        // empty
    }

}