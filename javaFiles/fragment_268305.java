@ServerEndpoint(value = "/websocket/{clientId}")
public class Service {
    private volatile String clientId; 
    @OnOpen
    public void init(@PathParam("clientId") String clientId, Session session) throws IOException {
         this.clientId = clientId;
    }
}