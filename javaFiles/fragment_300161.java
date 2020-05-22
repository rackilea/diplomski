@Override
public void doFilter(ServletRequest req, ServletResponse res, 
FilterChain filterChain) throws IOException, ServletException {
  // other code is omitted for brevity
  //move on to the next filter in the chains
  filterChain.doFilter(req, res);
}