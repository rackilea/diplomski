public interface Message {
   /*
    * Will be {
    *    handler.handleMessage(ctx, this);
    * }
    * everywhere.
    */
   void handleTo(ChannelHandlerContext ctx, Handler handler);
}