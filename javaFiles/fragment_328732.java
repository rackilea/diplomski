packet.setUByte(14, 0x40 | 0x05);
packet.scan(JProtocol.ETHERNET_ID);  

Ip4 ip4 = packet.getHeader( new Ip4() );
ip4.type(0x06); //TCP
ip4.length( packetSize - ethernet.size() );
ip4.ttl(...);  
...