@Override
public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    RecyclableArrayList out = RecyclableArrayList.newInstance();
    try {
        if (cumulation != null) {
            callDecode(ctx, cumulation, out);
            decodeLast(ctx, cumulation, out);
        } else {
            decodeLast(ctx, Unpooled.EMPTY_BUFFER, out);
        }
    } catch (DecoderException e) {
        throw e;
    } catch (Exception e) {
        throw new DecoderException(e);
    } finally {
        ...
    }
}