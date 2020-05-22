public class GSONDecoder
    extends ReplayingDecoder<Void> {

    Gson gson = new GsonBuilder().create();

    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) 
        throws Exception {

        out.add(gson.fromJson(new ByteBufInputStream(buf, false), Object.class));
    }
}