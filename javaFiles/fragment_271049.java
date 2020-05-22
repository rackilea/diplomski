private static final Map<String, String> urlMapping = new HashMap<String, String>();

static {
    urlMapping.put("/site/oldpage.nsf?home", "/site/newpage.jsp");
    // Put more here.
}

public doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException) {
    HttpServletRequest httpReq = (HttpServletRequest) request;
    String oldUrl = httpReq.getRequestURL().append("?").append(httpReq.getQueryString()).toString();
    String newUrl = urlMapping.get(oldUrl);
    response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
    response.setHeader("Location", newUrl);
}