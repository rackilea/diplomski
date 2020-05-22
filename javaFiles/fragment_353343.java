String path = ((HttpServletRequest) request).getRequestURI();
if (path.startsWith("/specialpath/")) {
    chain.doFilter(request, response); // Just continue chain.
} else {
    // Do your business stuff here for all paths other than /specialpath.
}