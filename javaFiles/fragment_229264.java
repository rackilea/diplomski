public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
{
    HttpServletRequest httpreq = (HttpServletRequest) request;
    String query = httpreq.getQueryString();
    if (query != null) {
        // Unfriendly URL invoked. Convert params to pathinfo and redirect.
        StringBuffer newURL = httpreq.getRequestURL();
        for (String param : query.split("&")) {
            newURL.append('/').append(param.substring(param.indexOf('=') + 1));
        }
        ((HttpServletResponse) response).sendRedirect(newURL.toString());
    } else {
        // Friendly URL invoked. Convert pathinfo to params and forward.
        String[] parts = httpreq.getRequestURI().replace(httpreq.getContextPath(), "").split("/");
        String newURL = String.format("%s?task=%s&id=%s", parts[1], parts[2], parts[3]);
        httpreq.getRequestDispatcher(newURL).forward(request, response);
    }
}