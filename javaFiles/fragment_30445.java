HttpClient client = HttpClient.newHttpClient();
HttpRequest req = HttpRequest.builder()
    .uri(URI.create("API LINK"))
    .POST(.... json here ...)
    .build();
client.send(req, HttpResponse.BodyHandlers.ofFile(Paths.get("/path/to/mp3")));