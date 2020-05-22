public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

    HttpRequest request = HttpRequest.newBuilder(new URI("https://jsonplaceholder.typicode.com/todos/1"))
                .header("Accept", "application/json")
                .build();

    Model model = HttpClient.newHttpClient()
                .send(request, new JsonBodyHandler<>(Model.class))
                .body();

    System.out.println(model);

}