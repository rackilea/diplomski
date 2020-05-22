public void doFilter(ServletRequest request, ServletResponse response,
             FilterChain chain) 
             throws IOException, ServletException {
  YourHttpServletRequest yourRequest =
              new YourHttpServletRequest(request, newServerName);
  chain.doFilter(yourRequest, response);
}