public static void allowOrigin(HttpServletRequest request, HttpServletResponse response) {
    String origin = request.getHeader(Headers.ORIGIN);
    // The Origin spec (http://tools.ietf.org/html/draft-abarth-origin-09) allows for the Origin
    // http header value to be "null". This is for cases where a request doesn't have a valid
    // origin; for example, issuing a CORS request from a local file:// rather than a website. In
    // these cases, we'd like to enable CORS to facilitate testing; the mechanism for doing so is
    // to set the Access-Control-Allow-Origin header to '*'.
    origin = NULL_ORIGIN.equals(origin) ? "*" : origin;
    response.setHeader(Headers.ACCESS_CONTROL_ALLOW_ORIGIN, origin);
  }