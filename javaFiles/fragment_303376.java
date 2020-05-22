public enum Decoder implements IDecoder {
    INSTANCE;

    private final Map<Client, State> states = new HashMap<Client, State>();

    public Packet decode(Client client, ByteBuffer data) {
            return null;
    }
}