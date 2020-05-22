public class FooPacketHandler extends PacketHandler<Foo> {
    public FooPacketHandler() {
        super(Foo.class);
    }

    protected void handlePacket(Foo packet) {
        ...
    }
}