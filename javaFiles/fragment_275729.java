public class IntegerHeaderFrameEncoder extends MessageToByteEncoder<byte[]> {
    @Override
    protected void encode(final ChannelHandlerContext paramChannelHandlerContext,
            final byte[] msg, final ByteBuf out) throws Exception {
        out.writeInt(msg.length);
        out.writeBytes(msg);
    }
}