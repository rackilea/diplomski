import javax.websocket.server.ServerEndpoint;
import javax.inject.Inject;

@ApplicationScoped
@ServerEndpoint("/actions")
public class DeviceWebSocketServer {

    @Inject
    private DeviceSessionHandler sessionHandler;

    @OnOpen
    public void open(Session session) {
    }

    ...
}