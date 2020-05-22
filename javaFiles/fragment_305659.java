public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpSession session = httpReq.getSession(false); // if the fail login it doesnt create a session
    String path= httpReq.getRequestURI();
    if(path.endsWith(".css")){
      chain.doFilter(request,response);
      return;
    }


    if (session != null && session.getAttribute("user") == null && !excludeURLs.contains(httpReq.getServletPath()) ){
        RequestDispatcher rd = httpReq.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
        return;
    }

    chain.doFilter(request, response);
}