//handler extended from SimpleChannelInboundHandler<String>
@Override
protected void channelRead0(ChannelHandlerContext ctx, String data) throws  Exception {
  System.out.println(data);
  System.out.flush();
  if ("success".equals(data)) {
    isLoggedIn = true
    ctx.channel().writeAndFlush("success!");
    return;
  }
  ctx.channel().writeAndFlush("fail!");
}