public void doFilter(ServletRequest request,
  ServletResponse response, FilterChain chain) 
  throws IOException, ServletException {
  // .. pre filter logic
  chain.doFilter(request, response);
  // .. post filter logic
}