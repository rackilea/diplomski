public abstract class AbstractPacketHandler<T extends Packet>
    implements PacketHandler {

    private final Class<T> packetType;

    protected AbstractPacketHandler(Class<T> packetType) {
        this.packetType = packetType;
    }

    protected abstract void handlePacket(T packet);

    public boolean tryHandlePacket(Packet packet) {
        if (!packetType.isInstance(packet)) {
            return false;
        }
        handlePacket(packetType.cast(packet));
        return true;
    }
}