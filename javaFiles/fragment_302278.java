public static void main(String[] args) {
    var client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();
    var request = HttpRequest.newBuilder()
            .uri(new URI("https://service-that-needs-auth.example/"))
            .header("Authorization", basicAuth("username", "password"))
            .build();
    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
            .join();
}

private static String basicAuth(String username, String password) {
    return "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
}