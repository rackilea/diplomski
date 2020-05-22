HttpServletRequest httpRequest = (HttpServletRequest) req;
String requestURI = httpRequest.getRequestURI();
log.info("request uri " + requestURI);
if (!requestURI.toLowerCase().contains("endpoint-api-name")) {
  chain.doFilter(req, resp);
  return;
}