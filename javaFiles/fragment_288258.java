// In your main:
ChannelGroup allChannels =
         new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

// In your ChannelInitializer<SocketChannel>
ch.pipeline().addLast("grouper", new GlobalSendHandler());

// New class:
public class MyHandler extends ChannelInboundHandlerAdapter {
     @Override
     public void channelActive(ChannelHandlerContext ctx) {
         allChannels.add(ctx.channel());
         super.channelActive(ctx);
     }
 }