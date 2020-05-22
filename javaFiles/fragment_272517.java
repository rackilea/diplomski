private FilterConfig config;

@Override
public void init(FilterConfig config) {
    this.config = config;
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
    ServletContext context = config.getServletContext();
    // ...
}