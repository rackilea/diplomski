public class PortContextFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        int localPort = request.getLocalPort();

        // if else or case statements

        ServletRequest newRequest = PortContextHttpServletRequestWrapper(request, YourPortContext)

        filterChain.doFilter(newRequest, response);
    }

    public void destroy() {
        // Nothing to do
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        // Nothing to do.
    }

}