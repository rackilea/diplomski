@POST
@Path("/upload")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response upload(@CookieParam("CTSESSION") Cookie ctSessionCookie) {

    // Get the CTSESSION cookie value
    String ctSession = ctSessionCookie.getValue();

    // Initialize Apache HTTPClient and pass the obtained cookie as a header
    HttpPost request = new HttpPost("FileNet.REST.URL");
    request.addHeader("Cookie", "CTSESSION=" + ctSession);
    CloseableHttpClient client = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
    CloseableHttpResponse result = client.execute(request);

    // Obtain the result, construct Jersey Response, and send it out to the original caller
    Response.ok(result.toString()).build();
}