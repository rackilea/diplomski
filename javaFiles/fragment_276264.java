HttpServletResponse res = (HttpServletResponse) servletResponse;
HttpServletRequest req = (HttpServletRequest) servletRequest;

res.setContentType("application/json; charset=UTF-8;");

//use a PrintWriter here, since we also have to deal with UTF-8 characters
PrintWriter out = res.getWriter();