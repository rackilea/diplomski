Iterator<GatewayMsg> it = PacketQueue.iterator();
while (it.hasNext()) {
    GatewayMsg msg = it.next();
    it.remove();                 // <== This is allowed, provided the collection supports it
    packetHandler.onPacket(msg);
}