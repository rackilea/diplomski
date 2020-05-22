@Service
@ClientRequestFactoryForId(2)
public class AccountLoginClientRequestFactory implements ClientRequestFactory {

    @Override
    public ClientRequest createClientRequest(ByteBuffer data, ClientConnection client, int id) {
        new CM_ENTER_GAME(data, client, id);
    }
}