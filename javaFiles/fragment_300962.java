public void doFilter(ServletRequest req, ServletResponse res,
        FilterChain chain) throws IOException, ServletException {
    System.out.println("LoginFilter : doFilter : Start");
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);

    System.out.println("LoginFilter : doFilter : 111111");


    HttpSession session = request.getSession(false);

    //bypass the login page and login servlet

    if (request.getRequestURI().indexof("login.jsp") >= 0 ||
      request.getRequestURI().indexof("/LoginServlet") >= 0){
      System.out.println("LoginFilter : bypass the login");
      chain.doFilter(request, response);
    } else {
      if (session == null || session.getAttribute("user") == null) {
        System.out.println("LoginFilter : doFilter : 222222");
        response.sendRedirect("login.jsp");
        //response.sendRedirect(request.getContextPath() + "/login.jsp");
        //response.sendRedirect("login.jsp");
        //response.sendRedirect("http://localhost:8080/PROJECT_ELMS/login.jsp");
      } else {
        System.out.println("LoginFilter : doFilter : 33333333");
        chain.doFilter(request, response);
      }
    }
}