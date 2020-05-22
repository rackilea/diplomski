@ServerEndpoint (value="/mySillyApp", configurator= ..., decoders={...})
public class MySillyWebSocketServer
{
    @OnOpen
    public void open (Session session, EndpointConfig config)
    {
        JsrSession jsrSession = (JsrSession) session; // import org.eclipse.jetty.websocket.jsr356.JsrSession;
        WebSocketSession webSocketSession = jsrSession.getWebSocketSession (); // import org.eclipse.jetty.websocket.common.WebSocketSession;
        String clientIPAddressString = webSocketSession.getRemoteAddress ().getHostString ();
        ....
    }
    ...
}