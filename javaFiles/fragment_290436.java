String originalRequestURI = request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);

if (originalRequestURI != null) {
    // It was forwarded. Now get the query string as follows.
    String originalQueryString = request.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING);
}