public class MyInboundHandler extends ChannelInboundHandlerAdapter {
   @Override
   public void channelActive(ChannelHandlerContext ctx) {
       System.out.println("Connected!");
       ctx.fireChannelActive();
    }
 }