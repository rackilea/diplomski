public class RetryChannelHandler extends ChannelDuplexHandler {
    Queue<HttpObject> requestParts;

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof HttpRequest) {
            requestParts = new ArrayDeque<>();
            requestParts.add((HttpRequest)msg);
        } else if (msg instanceof HttpContent) {
            requestParts.add(((HttpContent)msg).duplicate().retain());
        }

        super.write(ctx, msg, promise);
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpResponse) {
            HttpResponse res = (HttpResponse)msg;
            if (res.status().code() == 503) {
                ctx.executor().schedule(new Runnable() {
                    @Override
                    public void run() {
                        HttpObject obj;
                        while ((obj = requestParts.poll()) != null) {
                            ctx.write(obj);
                        }
                        ctx.flush();
                    }
                }, 1000, TimeUnit.MILLISECONDS);
            } else {
                HttpObject obj;
                while ((obj = requestParts.poll()) != null) {
                    ReferenceCountUtil.release(obj);
                }
                super.channelRead(ctx, msg);
            }
        } else {
            super.channelRead(ctx, msg);
        }
    }
}