@Component
public class CachingRequestBodyFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest currentRequest = (HttpServletRequest) servletRequest;
        MultipleReadHttpRequest wrappedRequest = new MultipleReadHttpRequest(currentRequest);
        chain.doFilter(wrappedRequest, servletResponse);
    }
}