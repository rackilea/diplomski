//PageLogFilter 
public void doFilter(...) {
      HttpServletRequest req = (HttpServletRequest) request;
      if(req.getAttribute("originalUri") != null) {
          String strOriginalUri = (String) req.getAttribute("originalUri");
          //set it back to null
      req.setAttribute("originalUri", null);
      }
}