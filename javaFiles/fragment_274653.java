public class CustomFilter extends AmAgentFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (InitListener.isIAMEnabled()) {
            HttpSession session = httpRequest.getSession();
            String userType = (String) session.getAttribute(Constant.USER_TYPE);
            if ("internal".equals(userType)) {
                super.doFilter(servletRequest, servletResponse, filterChain);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}