try {
    validateRequest(request);
    // Do stuff with a valid request.
} catch (RequestException e) {
    response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
}