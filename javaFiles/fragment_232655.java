@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    // obtaining a sessionComplete value
    Object value = ((HttpServletRequest) request).getSession().getAttribute("sessionComplete");
    boolean sessionComplete = Boolean.valueOf(Objects.requireNonNull(value).toString());

    // go to the final page
    if (sessionComplete) {
        ((HttpServletResponse)response).sendRedirect("locationToRedirect");
    }

    // otherwise, pass a control to controllers
    chain.doFilter(request, response);
}