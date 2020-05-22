public interface Handler {
    void handleMessage(ChannelHandlerContext ctx, MessageType1 m);
    void handleMessage(ChannelHandlerContext ctx, MessageType2 m);
    ...
    void handleMessage(ChannelHandlerContext ctx, MessageTypeN m);
}