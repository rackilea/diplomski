public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    String path = req.getRequestURI();
    String topfolder = path.substring(1);
    if (topfolder.contains("/")) {
        topfolder = topfolder.substring(0, topfolder.indexOf("/"));
    }

    if (topfolder.startsWith("_")) {
        chain.doFilter(request, response);
    } else if (topfolder.endsWith(":")) {
        request.getRequestDispatcher(path.replaceFirst(":", "")).forward(request, response);
    } else {
        request.getRequestDispatcher("/MainServlet" + path).forward(request, response);
    }

}