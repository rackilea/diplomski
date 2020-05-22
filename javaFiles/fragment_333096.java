RouterFunction<?> route = RouterFunctions.route(RequestPredicates.GET("/hello"),
                request -> {
                    Mono<String> hi = Mono.just("hi");
                    return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(hi, String.class);
                });
HttpHandler httpHandler = RouterFunctions.toHttpHandler(route);
ReactorHttpHandlerAdapter adapter =
        new ReactorHttpHandlerAdapter(httpHandler);
HttpServer server = HttpServer.create().host("localhost").port(8080);
DisposableServer disposableServer = server.handle(adapter).bind().block();
disposableServer.onDispose().block();