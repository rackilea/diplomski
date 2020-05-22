private final Charset charset = Charset.forName("UTF-8");

@Override
protected void encode(final ChannelHandlerContext ctx, final ResponseData msg, final ByteBuf out) throws Exception {
    out.writeInt(msg.getIntValue());
    out.writeInt(msg.getStringValue().length());
    out.writeCharSequence(msg.getStringValue(), charset);
}