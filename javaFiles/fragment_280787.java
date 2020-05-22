if (sn.startsWith("www.")) {
    String url = "http://" + getDefaultDomain() + req.getContextPath() + req.getRequestURI();
    HttpServletResponse resp = (HttpServletResponse) response;
    resp.reset();
    resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
    resp.setHeader("Location", url);
    return;
}
chain.doFilter(request, response);