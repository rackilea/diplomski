public final class MyNTPUDPClient extends DatagramSocketClient {
    public static final int DEFAULT_PORT = 123;

private int _version = NtpV3Packet.VERSION_3;

public TimeInfo getTime(InetAddress host, int port) throws IOException {
    // if not connected then open to next available UDP port
    if (!isOpen()) {
        open();
    }

    NtpV3Packet message = new NtpV3Impl();
    message.setMode(NtpV3Packet.MODE_CLIENT);
    message.setVersion(_version);
    DatagramPacket sendPacket = message.getDatagramPacket();
    sendPacket.setAddress(host);
    sendPacket.setPort(port);

    NtpV3Packet recMessage = new NtpV3Impl();
    DatagramPacket receivePacket = recMessage.getDatagramPacket();

    TimeStamp now = TimeStamp.getCurrentTime();

    message.setTransmitTime(now);

    _socket_.send(sendPacket);
    _socket_.receive(receivePacket);

    long returnTime = System.currentTimeMillis();
    TimeInfo info = new TimeInfo(recMessage, returnTime, true);

    return info;
}

public TimeInfo getTime(InetAddress host) throws IOException {
    return getTime(host, NtpV3Packet.NTP_PORT);
}

public int getVersion() {
    return _version;
}

public void setVersion(int version) {
    _version = version;
}

}