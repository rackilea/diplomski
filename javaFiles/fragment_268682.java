public class AuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String url = request.getServletPath();
        HttpSession session = request.getSession(false);
        Authentication authentication = new Authentication(session,request);


        if (isAdminUrl(url) && !authentication.isLoggedIn()) {
            res.sendRedirect/admin/login");
        }
        chain.doFilter(req, res);
    }
}