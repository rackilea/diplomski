@Override
public void inboundBufferUpdated(final ChannelHandlerContext ctx, ByteBuf in) throws   Exception {
outboundChannel = null;
if (Proxy.connectionTable.channelId != 0) {
    outboundChannel = Proxy.allChannels.find(Proxy.connectionTable.channelId);
    if (outboundChannel.isActive()) {               
        System.out.println("NOTIFY channel id=" + outboundChannel.id() + " is active...");
        Rewrite rewrite = new Rewrite(byteBufConverter.byteBufToString(in), 2);
        in.clear();
        in = byteBufConverter.stringToByteBuf(rewrite.getFixedMessage());   
        outboundChannel.write(in);
        outboundChannel.flush().addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    ctx.channel().read();
                } else {
                    future.channel().close();
                }
            }
        });
    }
}
}