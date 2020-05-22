public static void main(final String[] args) {
    Observable<HttpServerExchange> exchangeObservable = Observable.create(observableEmitter -> {
        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        observableEmitter.onNext(exchange);
                    }
                }).build();
        server.start();
        observableEmitter.setCancellable(() -> server.stop());
    });

    exchangeObservable.subscribe(exchange -> {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello World");
    });
}