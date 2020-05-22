@ServerEndpoint(value = "/echo")
public class Echo {

    @OnOpen
    public void start(Session session) {
        //TODO
    }

    @OnClose
    public void end() {
        //TODO
    }

    @OnMessage
    public void incoming(String message) {
        //TODO
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        //TODO
    }

}