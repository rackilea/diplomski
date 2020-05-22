public class ResponseDecoder extends ByteToMessageDecoder {
    private static ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 4) {
            return;
        }
        byteBuf.markReaderIndex();
        int dataLength = byteBuf.readInt();
        if (byteBuf.readableBytes() < dataLength) {
            byteBuf.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        byteBuf.readBytes(data);
        RpcResponse response = mapper.readValue(data, RpcResponse.class);
        list.add(response);
    }
}
public class ResponseEncoder extends MessageToByteEncoder<RpcResponse> {
    private static ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, RpcResponse rpcResponse, ByteBuf byteBuf) throws Exception {
        byte[] bytes = mapper.writeValueAsBytes(rpcResponse);
        int dataLength = bytes.length;
        byteBuf.writeInt(dataLength);
        byteBuf.writeBytes(bytes);
        byteBuf.writeBytes(SerializationUtil.serialize(rpcResponse));

    }
}