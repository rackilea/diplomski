if (spamRequest()) {
    response.reset();
    response.setHeader("Connection", "close");
    response.setStatus(HttpStatus.TOO_MANY_REQUESTS_429);
    response.flushBuffer();
}