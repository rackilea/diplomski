public class X509AuthenticationConverter implements Function<ServerWebExchange, Mono<Authentication>> {

    @Override
    public Mono<Authentication> apply(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        try {
           // extract credentials here
           Authentication authentication = ...
           return Mono.just(authentication);
        } catch (Exception e) {
           // log error here
           return Mono.empty();
        }
    }
}