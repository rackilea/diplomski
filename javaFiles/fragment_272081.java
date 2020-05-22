HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create(uri))
    .build();

return client.sendAsync(request, responseInfo -> new StringSubscriber())
    .whenComplete((r, t) -> System.out.println("--- Status code " + r.statusCode()))
    .thenApply(HttpResponse::body);