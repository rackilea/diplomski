String uri = ((HttpServletRequest) request).getRequestURI();
if (uri.endsWith(".jsp")) {
    chain.doFilter(request, response); // Just let it go. The container's builtin JspServlet will pickup this.
} else {
    request.getRequestDispatcher("/controller" + uri).forward(request, response); // Goes to controller servlet.
}