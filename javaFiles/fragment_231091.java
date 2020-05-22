public String GetToken() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newBuilder()
            .build();

    HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://YOUR_OKTA_DOMAIN/oauth2/default/v1/token"))
            .headers("Content-type", "application/x-www-form-urlencoded",
                    "Authorization", "Basic " + Base64.getEncoder().encodeToString("CLIENT_ID:CLIENT_SECRET".getBytes()),
                    "Accept", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(
                    "&grant_type=client_credentials" ))
            .build();

    HttpResponse<?> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());       

    return response.body().toString();
}