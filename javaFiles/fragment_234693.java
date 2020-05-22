public class AdminLoginFilter implements Filter {

private FilterConfig filterConfig;
private String loginForm; 

public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
    loginForm = this.filterConfig.getInitParameter("Admin_login_form");
}

public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpSession session = httpRequest.getSession();

    ControlPanelUser adminUser = (ControlPanelUser) session.getAttribute(PageConstants.CONTROL_PANEL_USER); 

    if ((adminUser == null || adminUser.getBoId() < 1)) { //Send user to login form
        filterConfig.getServletContext().getRequestDispatcher(loginForm).forward(request, response); 
    } else {// Send user to requested page
        chain.doFilter(request,response); 
    }

}

public void destroy() {
    this.filterConfig = null;
}
}