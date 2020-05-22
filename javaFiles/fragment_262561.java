String lPath = ((HttpServletRequest) request).getRequestURI();
if (lPath.startsWith("/supported")) {
   chain.doFilter(request, response); 
} else {
  // not supported
}