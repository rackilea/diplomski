import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.MessageList;
import io.netty.handler.codec.ByteToMessageDecoder;

public class Splitter extends ByteToMessageDecoder {

private ByteBuf collector = Unpooled.buffer();
final RtspClientHandler rtspClientHandler;
final RtpClientHandler rtpClientHandler;

public Splitter(RtspClientHandler rtspClientHandler, RtpClientHandler rtpClientHandler) {
    this.rtspClientHandler = rtspClientHandler;
    this.rtpClientHandler = rtpClientHandler;
}

@Override
protected void decode(ChannelHandlerContext ctx, ByteBuf in, MessageList<Object> out) throws Exception {
    collector.writeBytes(in);
    in.discardReadBytes();
    in.clear();
    if (rtspClientHandler.getRTSPstate() != RtspClientHandler.RTSP_CLIENT_STATE.READY) {
        System.out.println("RTSP communication in progress");
        collector.retain();
        out.add(collector);
        return;
    }
    if (collector.readableBytes() > 0 && collector.getByte(0) != 0x24) {
        System.out.println("Clearing the Unpooled.buffer() (because it does not start with 0x24)");
        collector.readerIndex(collector.writerIndex());
        collector.discardReadBytes();
    }
    System.out.println("*****New bytes arrived");
    while (collector.readableBytes() > 0 && collector.getByte(0) == 0x24) {
        System.out.println("Length: " + collector.readableBytes());
        if (collector.readableBytes() > 4) {
            int lengthToRead = collector.getUnsignedShort(2);
            if (collector.readableBytes() >= (lengthToRead + 4)) {
                collector.skipBytes(4);
                if (collector.getByte(16) == 0x67 || collector.getByte(16) == 0x68) {
                    final byte bytes[] = new byte[lengthToRead];
                    collector.readBytes(bytes);
                    collector.discardReadBytes();
                    SPSPPSbuffer spspps = new SPSPPSbuffer();
                    spspps.setSPSPPS(bytes);
                    out.add(spspps);

                } else {
                    final byte packetArray[] = new byte[lengthToRead];// copy packet.
                    collector.readBytes(packetArray);
                    collector.discardReadBytes();
                    out.add(packetArray);
                }
            } else {
                System.out.println("Not enough length, " + (lengthToRead + 4) + " byte should be required (together with 4 bytes header)");
                return;
            }
        } else {
            System.out.println("Less than 5 bytes");
            return;
        }
    }
}