@Bean
public RouterFunction<ServerResponse> hello() {
    return route(GET("/hello"),
            request -> {
                Mono<String> hi = Mono.just("hi");
                return ServerResponse.ok().contentType(TEXT_PLAIN).body(hi, String.class);
            });
}