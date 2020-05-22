private boolean disabled;

@Override
public void init(FilterConfig config) throws ServletException {
    disabled = lookupSomeEnvironmentVariableAndReturnBooleanAccordingly();
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    if (disabled) {
        chain.doFilter(request, response);
        return;
    }

    // Original code here.
    // ...
}