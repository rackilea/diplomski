package org.eclipse.jetty.demo;

import java.net.URI;
import java.util.concurrent.Future;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.client.WebSocketClient;

@WebSocket
public class SecureClientSocket
{
    private static final Logger LOG = Log.getLogger(SecureClientSocket.class);

    public static void main(String[] args)
    {
        String url = "wss://qa.sockets.stackexchange.com/";

        SslContextFactory ssl = new SslContextFactory.Client();
        ssl.setEndpointIdentificationAlgorithm("HTTPS");
        HttpClient http = new HttpClient(ssl);
        WebSocketClient client = new WebSocketClient(http);
        try
        {
            http.start();
            client.start();
            SecureClientSocket socket = new SecureClientSocket();
            Future<Session> fut = client.connect(socket, URI.create(url));
            Session session = fut.get();
            session.getRemote().sendString("Hello");
            session.getRemote().sendString("155-questions-active");
        }
        catch (Throwable t)
        {
            LOG.warn(t);
        }
        finally
        {
            stop(http);
            stop(client);
        }
    }

    private static void stop(LifeCycle lifeCycle)
    {
        try
        {
            lifeCycle.stop();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @OnWebSocketConnect
    public void onConnect(Session sess)
    {
        LOG.info("onConnect({})", sess);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason)
    {
        LOG.info("onClose({}, {})", statusCode, reason);
    }

    @OnWebSocketError
    public void onError(Throwable cause)
    {
        LOG.warn(cause);
    }

    @OnWebSocketMessage
    public void onMessage(String msg)
    {
        LOG.info("onMessage() - {}", msg);
    }
}