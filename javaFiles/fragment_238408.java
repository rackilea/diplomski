@FunctionalInterface
public interface ClientRequestFactory {
    public ClientRequest createClientRequest(ByteBuffer data, ClientConnection client, int id);
}

public class ClientRequestSwitchboard {

    private final Map<Integer, ClientRequestFactory> mappings = new HashMap<>();

    public ClientRequestSwitchboard() {
        mappings.put(1, (data, client, id) -> new CM_ACCOUNT_LOGIN(data, client, id));
        mappings.put(2, (data, client, id) -> new CM_ENTER_GAME(data, client, id));
        // ... Add each of the remaining request types ...
    }

    public ClientRequest createClientRequest(ByteBuffer data, ClientConnection client, int id) {
        ClientRequestFactory factory = mappings.get(id);

        if (factory == null) {
            return createDefault(data, client, id);
        }
        else {
            return factory.createClientRequest(data, client, id);
        }
    }

    protected ClientRequest createDefault(ByteBuffer data, ClientConnection client, int id) {
        logUnknownRequest(client, id);
        return null;
    }
}