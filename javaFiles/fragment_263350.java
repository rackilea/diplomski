connection.connect();

    /* packet listener: listen for incoming messages of type IQ on the connection (whatever the buddy) */
    PacketFilter filter = new IQTypeFilter(IQ.Type.SET); // or IQ.Type.GET etc. according to what you like to filter. 

    connection.addPacketListener(new PacketListener() { 
        public void processPacket(Packet packet) {
            // HERE YOU PUT YOUR CODE TO HANDLE THE IQ MESSAGE
        }
    }, filter);