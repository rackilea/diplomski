@Override
 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
HttpServletResponse hsr = (HttpServletResponse) res;
hsr.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
hsr.setHeader("Pragma", "no-cache"); // HTTP 1.0.
hsr.setDateHeader("Expires", 0); // Proxies.
chain.doFilter(req, res);
 }