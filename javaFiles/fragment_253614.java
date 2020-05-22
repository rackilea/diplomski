public final class PartnerServerWebExchangeDecorator extends ServerWebExchangeDecorator {

    private final ServerHttpRequestDecorator requestDecorator;
    private final ServerHttpResponseDecorator responseDecorator;

    public PartnerServerWebExchangeDecorator(ServerWebExchange delegate) {
        super(delegate);
        this.requestDecorator = new PartnerServerHttpRequestDecorator(delegate.getRequest());
        this.responseDecorator = new PartnerServerHttpResponseDecorator(delegate.getResponse());
    }

    @Override
    public ServerHttpRequest getRequest() {
        return requestDecorator;
    }

    @Override
    public ServerHttpResponse getResponse() {
        return responseDecorator;
    }

}