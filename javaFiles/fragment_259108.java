public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
    throws ServletException, IOException {
    System.out.println("Reached AuthFilter");
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;
    HttpSession session = request.getSession(false);
    User user = (User)session.getAttribute("user");
    if (user == null) {
        System.out.println("Going to index.jsp");
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    } else {
        System.out.println("Going to the servlet ");
        chain.doFilter(req, resp);
    }
}