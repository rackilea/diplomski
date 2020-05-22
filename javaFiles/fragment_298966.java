@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession(false);
    String loginURL = request.getContextPath() + "/pages/index.xhtml";

    boolean loggedIn = (session != null) && (session.getAttribute("estaLoggeado") != null);
    boolean loginRequest = request.getRequestURI().equals(loginURL);
    boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");

    if (loggedIn || loginRequest || resourceRequest)) {
        chain.doFilter(request, response); // So, just continue request.
    }
    else {
        response.sendRedirect(loginURL); // So, redirect to login page.
    }
}