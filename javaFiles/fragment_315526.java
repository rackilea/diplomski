final Pcap pcap = Pcap.openStream("my_traffic.pcap");

pcap.loop(new PacketHandler() {
    @Override
    public void nextPacket(final Packet packet) throws IOException {
        if (packet.hasProtocol(Protocol.UDP)) {
            System.out.println(packet.getPacket(Protocol.UDP).getPayload());
        }
    }
});