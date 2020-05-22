if (req instanceof HttpServletRequest) {
    HttpServletRequest httpReq = (HttpServletRequest) req;
    StringBuffer url = httpReq.getRequestURL();
    if (httpReq.getQueryString() != null) {
        url.append("?");
        url.append(httpReq.getQueryString());
    }
    String urlString = url.toString();
}