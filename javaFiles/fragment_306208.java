public class LoginFilter implements javax.servlet.Filter {

    @Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {    
    HttpServletRequest req = (HttpServletRequest) request;
    BaseBean base = (BaseBean) req.getSession().getAttribute("baseBean");

    if (base != null && base.isLoggedIn()) {
        // to do something
        chain.doFilter(request, response);
    } else {
        // to do something
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(req.getContextPath() + "/index.xhtml");
    }
}

public void init(FilterConfig config) throws ServletException {
    // to do something
}

public void destroy() {
    // to do something
}   

}