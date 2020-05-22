private static final ClientRequestSwitchboard switchboard = new ClientRequestSwitchboard();

public static ClientRequest handle(ByteBuffer data, ClientConnection client) {
    int id = data.getShort();
    return switchboard.createClientRequest(data, client, id);
}