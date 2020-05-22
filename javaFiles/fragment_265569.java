public class UserRoleFilter implements Filter {    
    @Override
    public void init(FilterConfig cfg) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain next) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        //Manually check that the current user can access pages
        //I did that by storing stuff in the session which you can access by 
        //request.getSession().getAttribute(someKey);
        if(!userHasAccessToRestrictedPages) {
            HttpServletResponse r = (HttpServletResponse) response;
            r.sendRedirect(request.getContextPath() + "/signin.xhtml");
            return;
        }

        next.doFilter(req, response);
    }

    @Override
    public void destroy() {
    }
}