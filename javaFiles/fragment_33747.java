public void receive(Message msg) {
    String srcIp;   
    Address addr = msg.getSrc();

    PhysicalAddress physicalAddr = (PhysicalAddress)channel.down(new Event(Event.GET_PHYSICAL_ADDRESS, addr));

    if(physicalAddr instanceof IpAddress) {
        IpAddress ipAddr = (IpAddress)physicalAddr;
        InetAddress inetAddr = ipAddr.getIpAddress();
        srcIp = inetAddr.getHostAddress();
    }
}