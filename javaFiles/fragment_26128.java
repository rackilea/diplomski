private final AttributeKey<StringBuffer> dataKey = AttributeKey.valueOf("dataBuf");

@Override
public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ByteBuf byteBuf;
    String data, hostAddress;

    StringBuffer dataBuf = ctx.attr(dataKey).get();
    boolean allocBuf = dataBuf == null;
    if (allocBuf) dataBuf = new StringBuffer();

    byteBuf = (ByteBuf) msg;
    data = byteBuf.toString(CharsetUtil.UTF_8);
    hostAddress = ((InetSocketAddress) ctx.channel().remoteAddress()).getAddress().getHostAddress();

    if (!data.isEmpty()) {
        this.logger.info(String.format("Data received %s from %s", data, hostAddress));
    }
    else {
        logger.info(String.format("NO Data received from %s", hostAddress));
    }

    dataBuf.append(data);
    if (allocBuf) ctx.attr(dataKey).set(dataBuf);

    ctx.channel().read();
}

@Override
public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    StringBuffer dataBuf = ctx.attr(dataKey).get();
    if (dataBuf != null) {
        String reply;

        reply = this.responseManager.reply(dataBuf.toString());

        if (reply != null) {
            ctx.write(Unpooled.copiedBuffer(reply, CharsetUtil.UTF_8));
        }
    }
    ctx.attr(dataKey).set(null);

    ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
}