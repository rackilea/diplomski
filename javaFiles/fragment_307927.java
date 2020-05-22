private boolean canServe = false;

public void init(FilterConfig fc) {
    if( filter activation condition ) {
        canServe = true;
    }
}

public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
    if( canServe ) {
        // filter logic - filter is ON
    }
    else chain.doFilter(request, response); // filter is OFF
}