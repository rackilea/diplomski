package org.hectorvent.gpstracking.websocket;

import org.hectorvent.gpstracking.restful.model.PdaGeoData;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@Singleton
@ServerEndpoint("/geodata")
public class WebSocketGmap {

    private final Set<Session> clients = new HashSet();

    @OnOpen
    public void open(Session session) {
        clients.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
          // here you're going to received client messages.
    }

    @OnClose
    public void close(Session session) {
        clients.remove(session);
    }

    @OnError
    public void onError(Throwable error) {
    }

    public void sendMessage(PdaGeoData pgd) {
        for (Session client : clients) {
            Future fu = client.getAsyncRemote()
                    .sendText(GsonUtils.toJson(pgd));

        }
    }

}