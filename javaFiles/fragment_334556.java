@Override
public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    final ResponseData responseData = (ResponseData) msg;
    System.out.println("The message sent from the server " + responseData);
    update.accept(responseData.getIntValue());
}