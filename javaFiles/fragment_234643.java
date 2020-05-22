public class Iso8583MessageBOKImpl implements Iso8583Message{
...
        org.jpos.iso.ISOPackager customPackager = new GenericPackager(isoPackagerLocation+iso8583Properties.getPackager());
        BaseChannel channel = new ASCIIChannel(iso8583Properties.getServerIp(), Integer.parseInt(iso8583Properties.getServerPort()), customPackager);// live
        channel.setLogger(Logger.getLogger("Q2"),"connectips-channel");
...
}