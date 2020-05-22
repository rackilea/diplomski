@Override
public void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
     msg.retain(); // ferrybig: fixed bug http://stackoverflow.com/q/34634750/1542723
     ctx.fireChannelRead(msg);
     //group.writeAndFlush(msg.retain());
}