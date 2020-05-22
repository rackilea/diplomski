public class SaveRequestResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        RequestResponseHolder.setRequestResponse(req,resp);
        try {
            chain.doFilter(request, response);
        }
        finally {
            RequestResponseHolder.clear();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ...
    }

    @Override
    public void destroy() {
       ...
    }
}