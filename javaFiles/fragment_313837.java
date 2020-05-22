@Override
public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    return chain.filter(exchange)
            .then(Mono.fromRunnable(refreshCookies(exchange)));
}

Runnable refreshCookies(ServerWebExchange exchange) {
    return () -> {
        //magic happens here ....
    };
}