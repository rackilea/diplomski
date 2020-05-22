private static final String ALLOWED_DOMAINS_REGEXP = ".*";

HttpServletRequest req = (HttpServletRequest) servletRequest;
HttpServletResponse resp = (HttpServletResponse) servletResponse;

String origin = req.getHeader("Origin");
if (origin != null && origin.matches(ALLOWED_DOMAINS_REGEXP)) {
  resp.addHeader("Access-Control-Allow-Origin", origin);
  resp.setHeader("Allow", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS");
  if (origin != null) {
      String headers = req.getHeader("Access-Control-Request-Headers");
      String method = req.getHeader("Access-Control-Request-Method");
      resp.addHeader("Access-Control-Allow-Methods", method);
      resp.addHeader("Access-Control-Allow-Headers", headers);
      resp.setContentType("text/plain");
  }
}