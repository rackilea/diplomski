public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) {
    HttpServletRequest request = (HttpServletRequest) req;
    Principal user = request.getUserPrincipal();
    HttpSession session = request.getSession(false);

    if (user != null && (session == null || session.getAttribute("user") == null)) {
        request.getSession().setAttribute("user", user);

        // First-time login. You can do your intercepting thing here.
    }

    chain.doFilter(req, res);
}