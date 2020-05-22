public class CSRFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        MultiReadHttpServletRequest multiReadHttpServletRequest = new MultiReadHttpServletRequest(request);
        CSRF csrf = new CSRF(multiReadHttpServletRequest);
        if(csrf.isOk()){
            chain.doFilter(multiReadHttpServletRequest, res);
        }else {
            //todo : Show Error Page
            String redirect = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/access-forbidden";
            response.sendRedirect(redirect);
        }
    }
}