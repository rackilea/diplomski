public static void main(String[] args) throws Exception {
    File f = new File("sample.pcap");

    EthernetDecoder eth = new EthernetDecoder();
    IpDecoder ip = new IpDecoder();
    TcpDecoder tcp = new TcpDecoder(new TcpPortProtocolMapper());
    UdpDecoder udp = new UdpDecoder(new UdpPortProtocolMapper());

    eth.register(EthernetType.IPV4, ip);
    ip.register(InternetProtocol.TCP, tcp);
    ip.register(InternetProtocol.UDP, udp);

    PcapInputStream is = new PcapFileInputStream(f);
    while (true) {
        // getPacket() will throws EOFException and you should call is.close() 
        PcapPacket packet = is.getPacket();
        eth.decode(packet);
    }
}