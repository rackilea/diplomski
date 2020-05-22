@Component
public class TracingFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return chain.filter(new PartnerServerWebExchangeDecorator(exchange));
    }
}