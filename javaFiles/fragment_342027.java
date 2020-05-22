@Sharable
public class MessageHandler extends SimpleChannelHandler implements Handler {
   ...
   @Override
   public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
     if (e.getMessage() instanceof Message) {
        Message m = (Message) e.getMessage();
        m.handleTo(ctx, this);
    } else {
        ctx.sendUpstream(e);
    }
}

@Override
public void handleMessage(ChannelHandlerContext ctx, MessageType1 m) {
    ...
}