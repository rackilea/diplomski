packet.setUByte(46, 0x50);
packet.scan(JProtocol.ETHERNET_ID);  

Tcp tcp = packet.getHeader( new Tcp() );  
tcp.seq(...); 
...