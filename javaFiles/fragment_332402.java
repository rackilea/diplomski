@Override
 public void destroy() {
     // TODO Auto-generated method stub

 }

 @Override
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
 throws IOException, ServletException {

     HttpServletRequest httpRequest = (HttpServletRequest) request;
     HttpServletResponse httpResponse = (HttpServletResponse) response;
     httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
     httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
     httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
     httpResponse.setHeader("Access-Control-Max-Age", "3600");
     httpResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization, Content-Type,*");
     if (httpRequest.getMethod().equals("OPTIONS")) {
         httpResponse.setStatus(HttpServletResponse.SC_OK);
         return;
     }
     chain.doFilter(httpRequest, httpResponse);
 }


 @Override
 public void init(FilterConfig arg0) throws ServletException {
     // TODO Auto-generated method stub

 }