void addHttpsForward(ServletContextHandler handler) {
  handler.addFilter(new FilterHolder(new Filter() {

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
      StringBuffer uri = ((HttpServletRequest) request).getRequestURL();
      if (uri.toString().startsWith("http://")) {
        String location = "https://" + uri.substring("http://".length());
        ((HttpServletResponse) response).sendRedirect(location);
      } else {
        chain.doFilter(request, response);
      }
    }

    public void destroy() {}
  }), "/*", EnumSet.of(DispatcherType.REQUEST));
}

@Override
public void run(ExampleConfiguration configuration, Environment environment) throws Exception {
  //...
  if (configuration.forwardHttps()) {
    addHttpsForward(environment.getApplicationContext());
  }
  //...      
}