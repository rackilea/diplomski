if (request instanceof HTTPServletRequest) {
    HTTPServletRequest httpRequest = (HTTPServletRequest) request;
    // read X-Forwarded-For header, etc. etc.
} else {
    ip = request.getRemoteAddr();
}