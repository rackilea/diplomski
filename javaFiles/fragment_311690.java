public class ExceptionFilter implements Filter {
    private FilterConfig filterConfig;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
        throws IOException, ServletException {

        try {
            filterChain.doFilter(request, response);
        }
        catch (Exception ex) {
            String errorId = UUID.randomUUID().toString();
            Mylog.e("Server error " + errorId); // Use whatever logging mechanizm you prefer
            String clientResponse = "Server error. Reference no: " + errorId;     
            ((HttpServletResponse) response).setStatus(500);                
            response.getWriter().write(clientResponse);
        }
    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {}      
}