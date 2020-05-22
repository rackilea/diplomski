@RequiredArgsConstructor
private static class TimeoutHandler extends ChannelInboundHandlerAdapter {
    private final int timeoutSeconds;

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        ctx.executor().schedule(
                // This exception can still be fired once the channel is closed and all handlers removed
                () -> ctx.fireExceptionCaught(new TimeoutException()), 
                timeoutSeconds, TimeUnit.SECONDS);
        super.channelRegistered(ctx);
    }
}