//LoginServlet
public void doFilter(...) {
      HttpServletRequest oReq = (HttpServletRequest)request;
      ..
      ...
      //save original request URI
      oReq.setAttribute("originalUri", oReq.getRequestURI());
}