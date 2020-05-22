public class WebSocketSslServerHandler extends SimpleChannelInboundHandler<Object>
{
     ExecutorService cachedPool;

     public WebSocketSslServerHandler (ExecutorService pool)
     {
         this.cachedPool = pool;
     }

     @Override
     public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception
     {
         if (msg instanceof WebSocketFrame)
         {
              cachedPool.submit(new MessageHandler(ctx, (WebSocketFrame) msg));
         }
     }
}