@Test
public void testGoodWay() throws Exception {
    ClientConfig config = new DefaultClientConfig();
    config.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
    com.sun.jersey.api.client.Client client = Client.create(config);
    client.setFollowRedirects(true);

    LoggingFilter logging = new LoggingFilter(Logger.getAnonymousLogger());



    WebResource service = client.resource(UriBuilder.fromUri("http://mail.google.com").build());
    service.addFilter(logging);
    service.addFilter(new RedirectFilter());

    try {
        String output = service.path("mail")
            .accept(MediaType.TEXT_HTML)
            .get(String.class);

        System.out.println(output);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

class RedirectFilter extends ClientFilter {

    @Override
    public ClientResponse handle(ClientRequest cr) throws ClientHandlerException {
        ClientHandler ch = getNext();
        ClientResponse resp = ch.handle(cr);

        if (resp.getClientResponseStatus().getFamily() != Response.Status.Family.REDIRECTION) {
            return resp;
        }
        else {
            // try location
            String redirectTarget = resp.getHeaders().getFirst("Location");
            cr.setURI(UriBuilder.fromUri(redirectTarget).build());
            return ch.handle(cr);
        }

    }

}