String uri = ((HttpServletRequest) request).getRequestURI();
if (uri.startsWith("/content/css/") || uri.startsWith("/content/image/") || uri.startsWith("/content/js/")) {
    chain.doFilter(request, response); // Goes to default servlet.
} else {
    request.getRequestDispatcher("/pages" + uri).forward(request, response);
}