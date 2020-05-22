private PacketListener packetListener = new PacketListener() {
        @Override
        public void processPacket(Packet packet) {
            if (packet instanceof Message) {
                Message message = (Message) packet;
                String chatMessage = message.getBody();
            }
        }
    };

    private void regiSterPackateListner() {
        PacketTypeFilter filter = new PacketTypeFilter(Message.class);
        try {
            if (packetListener != null) {
                //Avoid adding multiple packetlistner
                abstractXMPPConnection.removePacketListener(packetListener);
            }
            abstractXMPPConnection.addPacketListener(packetListener, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }