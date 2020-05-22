private static final String CHALLENGE_FORMAT = "%s realm=\"%s\"";

private Response createUnauthorizedResponse() {
    return Response.status(Response.Status.UNAUTHORIZED)
            .header(HttpHeaders.WWW_AUTHENTICATE, String.format(CHALLENGE_FORMAT, "Basic", "Access"))
            .type(MediaType.TEXT_PLAIN_TYPE)
            .entity("Credentials are required to access this resource.")
            .build();