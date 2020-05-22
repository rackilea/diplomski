public class IPFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if ("/api/v1/auth/user".equals(((HttpServletRequest) request).getRequestURI())) {
             //skip
            chain.doFilter(request, response);
            return; //   <--- important line
        }
        ...
    }
    ...
}