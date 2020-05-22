@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
    HttpServletRequest request = (HttpServletRequest) req;
    String username = request.getRemoteUser();

    if (username != null && request.getSession().getAttribute("user") == null) {
        // First-time login. You can do your thing here.
        User user =  yourUserService.find(username);
        request.getSession().setAttribute("user", user);
    }

    chain.doFilter(req, res);
}