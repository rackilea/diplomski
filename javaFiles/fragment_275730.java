public class IntegerHeaderFrameDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(final ChannelHandlerContext ctx, final ByteBuf buf,
            final List<Object> out) throws Exception {
        out.add(buf.readBytes(buf.readInt()));
    }
}