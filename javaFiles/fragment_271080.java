public static void main(String[] args) throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        UncheckedObjectMapper uncheckedObjectMapper = new UncheckedObjectMapper();

        HttpRequest request = HttpRequest.newBuilder(new URI("https://jsonplaceholder.typicode.com/todos/1"))
                .header("Accept", "application/json")
                .build();

        Model model = HttpClient.newHttpClient()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(uncheckedObjectMapper::readValue)
                .get();

        System.out.println(model);

}

static class UncheckedObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {
        /**
         * Parses the given JSON string into a Map.
         */
        Model readValue(String content) {
            try {
                return this.readValue(content, new TypeReference<Model>() {
                });
            } catch (IOException ioe) {
                throw new CompletionException(ioe);
            }
        }

}

static class Model {
        private String userId;
        private String id;
        private String title;
        private boolean completed;


    //getters setters constructors toString
}