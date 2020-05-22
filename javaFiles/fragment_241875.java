// Assumes you use some dependency injection framework
@Component 
// Your own POJO to be notified of every socket events
public class WebSocketListener {
    public void onOpen(String id) {
        // Your logic here
    }

    public void onMessage(String id, Object message) {
        // Your logic here
    }

    public void onClose(String id) {
        // Your logic here
    }
}

// A parent class to notify your own global listener
// Extend it if you want to listen socket's event through some specific path
public abstract class NotifiableEndpoint {
    @Inject
    private WebSocketListener listener;

    @OnOpen
    public void onOpen(Session session) {
        listener.onOpen(session.getId());
    }

    @OnMessage
    public void onMessage(Session session, StringOrByteBuffer data) {
        listener.onOpen(session.getId(), data);
    }

    @OnClose
    public void OnClose(Session session) {
        listener.onOpen(session.getId());
    }
}

// A concrete class to write your business logic
@ServerEndpoint("/hello")
public class YourEndpoint extends NotifiableEndpoint {
    // Your logic
}