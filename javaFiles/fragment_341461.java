public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {

    String uri = ((HttpServletRequest) request).getRequestURI();
    String path = uri.replace(
            ((HttpServletRequest) request).getContextPath(), "");

    if (path.startsWith("/view/")) {
        String rd = path.replace("/view/", "/jsp/") + ".jsp";
        request.getRequestDispatcher(rd).forward(request, response);
    } else {
        chain.doFilter(request, response);
    }
}