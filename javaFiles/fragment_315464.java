public class ServerCommandHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.channel().attr(NettyServer.COMMANDKEY).set(clCommand);
        ctx.fireChannelRead(msg);
    }
}

public class ServerChecksumHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if ctx.channel().attr(NettyServer.COMMANDKEY).getAndRemove() == referenceCommand {
            //do something
        }
    }
}