private final String baseURL = "https://api.mailgun.net/v2/";

private String mailgunAPIKey;

private <T> WebTarget createPrivateClient() {
    final Client client = ClientBuilder.newClient();
    client.register(HttpAuthenticationFeature.basic("api", this.mailgunAPIKey));
    return client.target(this.baseURL);
}

protected void fireMailGun(final MultivaluedMap<String, String> postData) {
    this.createPrivateClient().path("YOUR_DOMAIN/messages")
                              .request()
                              .post(Entity.form(postData));
}