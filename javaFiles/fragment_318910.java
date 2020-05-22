public class MyChannelInitializer extends ChannelInitializer<Channel> {
     @Override
     public void initChannel(Channel channel) {
         channel.pipeline().addLast("idleStateHandler", new IdleStateHandler(60, 30, 0));
         channel.pipeline().addLast("myHandler", new MyHandler());
     }
 }

 // Handler should handle the IdleStateEvent triggered by IdleStateHandler.
 public class MyHandler extends ChannelHandlerAdapter {
     @Override
     public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
         if (evt instanceof IdleStateEvent) {
             IdleStateEvent e = (IdleStateEvent) evt;
             if (e.state() == IdleState.READER_IDLE) {
                 ctx.close();
             } else if (e.state() == IdleState.WRITER_IDLE) {
                 ctx.writeAndFlush(new PingMessage());
             }
         }
     }
 }