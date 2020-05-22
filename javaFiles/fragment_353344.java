String path = ((HttpServletRequest) request).getRequestURI();
if (path.startsWith("/specialpath/")) {
    chain.doFilter(request, response); // Just continue chain.
} else {
    request.getRequestDispatcher("/otherfilterpath" + path).forward(request, response);
}