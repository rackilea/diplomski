public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException
  {
    HttpServletRequest httpRequest=(HttpServletRequest)request;
    HttpServletResponse httpResponse=(HttpServletResponse)response;
       Enumeration headerNames = httpRequest.getHeaderNames();
        while(headerNames.hasMoreElements()) {
          String headerName = (String)headerNames.nextElement();
          out.println(headerName);
          out.println(request.getHeader(headerName));
        }
       chain.doFilter(request,response);
}