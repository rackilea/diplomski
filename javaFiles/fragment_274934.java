public class HttpResponseHeadersHandler extends ChannelInboundHandlerAdapter {
    private final HttpHeaders httpHeaders;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof HttpResponse &&
                !HttpStatus.resolve(((HttpResponse) msg).status().code()).is1xxInformational()) {
            HttpHeaders headers = ((HttpResponse) msg).headers();

            httpHeaders.forEach(e -> {
                log.warn("Modifying {} from: {} to: {}.", e.getKey(), headers.get(e.getKey()), e.getValue());
                headers.set(e.getKey(), e.getValue());
            });
        }
        ctx.fireChannelRead(msg);
    }
}