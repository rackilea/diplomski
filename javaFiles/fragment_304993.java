@Bean
public CommandLineRunner readFromApiServer() {
    return new CommandLineRunner() {
        @Override
        public void run(String... args) throws Exception {
            WebClient webClient = WebClient.create("http://localhost:8080");
            Flux<Power> flux = webClient.get().uri("/power").accept(MediaType.APPLICATION_STREAM_JSON).exchange()
                    .flatMap(response -> response.bodyToFlux(Power.class));
            List<Power> powerList = flux.collectList().block();
            // do something with the result?
        }
    };
}